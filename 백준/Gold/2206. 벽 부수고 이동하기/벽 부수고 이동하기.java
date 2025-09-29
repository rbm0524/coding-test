import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, ans, index;
  static String[] A;
  static int[][] wall;
  static int final_path = Integer.MAX_VALUE;
  static int[][] path;
  static int[][][] visit;
  static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    q.offer(0);
    q.offer(0);
    q.offer(0);
    visit[0][0][0] = 1;

    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();
      int breaked = q.poll();

      for(int i = 0; i < 4; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];
        if(_x < 0 || _y < 0 || _x >= N || _y >= M) continue;
        // 방문한 적 있음
        if(visit[_x][_y][breaked] > 0) continue;
        
        //TODO : q에 추가하기
        if(A[_x].charAt(_y) == '1') { // 다음 것이 벽일 때
          if(breaked == 0) { // 부순적이 없어야 함
            visit[_x][_y][1] = visit[x][y][0] + 1;// 이제 부순다.
            q.offer(_x);
            q.offer(_y);
            q.offer(1); // 부순 상태로 변경
          }
        } else { // 벽이 아닐 때
          if(breaked == 1) { // 깬 적이 있다.
            visit[_x][_y][1] = visit[x][y][1] + 1; // 부순 상태라면 부순 상태를 이어가야 한다.
          } else { // 깬 적이 없다.
            visit[_x][_y][0] = visit[x][y][0] + 1; // 안 부순 상태라면 안 부순 상태를 이어가야 한다.
          }
          q.offer(_x);
          q.offer(_y);
          q.offer(breaked); // 현재 상태 유지
        }
      }
      /*
        '벽 안 부순 경로(상태 0)'가 탐색을 진행하다가 (1,0)에 도착했다고 합시다. 그 옆에는 (1,1) 벽이 있다.
        여기서 (1,1) 벽을 뚫는 새로운 가능성인 (1,1, 상태 1)을 큐에 추가합니다.
        그런데, 원래 경로는 (1,1)을 무시하고 계속 길을 따라 탐색을 이어갈 수도 있다. 그렇게 (2,2)까지 도착했고, 그 옆에는 (2,3) 벽이 있습니다.
        그러면 이 경로는 여기서 (2,3) 벽을 뚫는 또 다른 새로운 가능성인 (2,3, 상태 1)을 큐에 추가합니다.
        즉, 큐에 추가한다면 탐색을 시도하게 되니, 각 벽을 부쉈을 때를 기점으로 탐색을 수행해보게 된다.
      */
    }
  }
  
  static void pro() {
    bfs();

    if(visit[N-1][M-1][0] == 0 && visit[N-1][M-1][1] == 0) { // 도달 못할 때
      System.out.println(-1);
    } else if(visit[N-1][M-1][0] == 0) {
      System.out.println(visit[N-1][M-1][1]);
    } else if(visit[N-1][M-1][1] == 0){
      System.out.println(visit[N-1][M-1][0]);
    } else {
      System.out.println(Math.min(visit[N-1][M-1][0], visit[N-1][M-1][1]));
    }
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new String[N];
    visit = new int[N][M][2];

    for(int i = 0; i < N; i++) {
      A[i] = br.readLine();
    }
    
    pro();
    
    
  }
}
