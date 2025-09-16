import java.util.*;
import java.io.*;

public class Main{
  //20:00부터
  static StringBuilder sb = new StringBuilder();
  static int A,B,C;
  static int[] Limit;
  static boolean[] possible;
  static boolean[][][] visit;

  static class State {
    int[] X;
    
    State(int[] _X) {
      X = new int[3];
      for(int i = 0; i < 3; i++) {
        X[i] = _X[i];
      }
    }

    // from에서 to로 물을 옮긴다.
    State move(int from, int to, int[] Limit) {
      int[] nX = new int[]{X[0], X[1], X[2]};

      // to가 먼저 찰 때
      if(X[from] + X[to] >= Limit[to]) {
        nX[from] = nX[from]- (Limit[to]-X[to]);
        nX[to] = Limit[to];
      } else { // 다 부을 수 있을 때
        nX[to] += nX[from];
        nX[from] = 0;
      }
    
      return new State(nX);
    }
  }

  static void bfs(int x1, int x2, int x3) {
    Queue<State> Q = new LinkedList<>();
    visit[x1][x2][x3] = true;

    Q.offer(new State(new int[]{x1, x2, x3}));

    while(!Q.isEmpty()) {
      State st = Q.poll();

      if(st.X[0] == 0) { // A번 물통이 비어있다면
        possible[st.X[2]] = true;
      }

      for(int from = 0; from < 3; from++) {
        for(int to = 0; to < 3; to++) {
          if(from == to) continue; // 같은 물통이면 pass
          State nxt = st.move(from, to, Limit);
          
          if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
            visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
            Q.offer(nxt);
          }
        }
      }
        
    }
    
  }
    
  static void pro() {
    
    bfs(0, 0, Limit[2]); // 시작은 0, 0, C니까

    for(int i = 0; i <= Limit[2]; i++) { // 담겨있을 수 있는 물의 양이 최대값 내에서 찾기
      if(possible[i]) sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
  
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 각 용량
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    Limit = new int[]{A, B, C};
    possible = new boolean[205]; // C에 들어있을 수 있는 물의 양을 체크
    visit = new boolean[205][205][205];
    
    pro();
    
    
  }
}
