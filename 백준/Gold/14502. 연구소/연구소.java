import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, B;
  static int ans = 0;
  static int[][] A;
  static int[][] blank; // 비어있는 공간의 위치 저장 (좌표 나열)
  static boolean[][] visit;
  static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  // 바이러스 퍼뜨리기
  static void bfs() {
    Queue<Integer> Q = new LinkedList<>();
    //모든 바이러스가 시작점으로 가능하니까 전부 큐에 넣어준다.
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        visit[i][j] = false; // false로 초기화 후 다음 조건을 만족하면 true로 바꾸도록
        if(A[i][j] == 2) {
          Q.offer(i);
          Q.offer(j);
          visit[i][j] = true;
          // 먼저 넣은 것을 행, 두 번째 넣은 것을 열이라고 정해놓으면 Integer로만 Queue에 넣어도 된다.
        }
      }
    }
    
    // BFS
    while(!Q.isEmpty()) {
      int x = Q.poll();
      int y = Q.poll();
      
      for(int k = 0; k < 4; k++) {
        int _x = x + dir[k][0];
        int _y = y + dir[k][1];

        // 올바른 영역인지는 항상 체크
        if(_x < 1 || _y < 1 || _x > N || _y > M) continue;
        
        if(A[_x][_y] == 1 || A[_x][_y] == 2 || visit[_x][_y]) {
          continue;
        } else {
          Q.offer(_x);
          Q.offer(_y);
          visit[_x][_y] = true;
        }
      }
    }

    // 탐색이 종료된 시점이니 안전 영역의 넓이를 계산하고 정답을 갱신한다.
    int cnt = 0;
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <=M; j++) {
        if(A[i][j] == 0 && !visit[i][j]) { // 0이면서 visit체크가 안된 부분은 벽에 가로막혀서 못간 부분 
          cnt++; // 바이러스가 확산하지 못한 경우기 때문에 cnt를 늘린다.
        }
      }
    }

    ans = Math.max(ans, cnt);
    
  }

  // idx번째 빈 칸에 벽을 세울 지 말지 결정해야 하고, 이전까지 selected_cnt개의 벽을 세운 것.
  static void dfs(int idx, int selected_cnt) {
    //벽을 3개 모두 세움
    if(selected_cnt == 3) {
      bfs();
      return;
    }
    if(idx > B) return; // 더 이상 세울 수 있는 벽이 없을 때

    A[blank[idx][0]][blank[idx][1]] = 1; // 벽을 세우기
    dfs(idx+1, selected_cnt+1);

    A[blank[idx][0]][blank[idx][1]] = 0; // 이전에 벽을 세운 부분도 안세웠을 때의 dfs해보기
    dfs(idx+1, selected_cnt);
    
  }
  
  static void pro() {
    // 모든 벽의 위치 모으기(비어있는 공간을 모아서 벽을 거르기)
    // 그냥 좌표의 나열임!
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        if(A[i][j] == 0) {
          B++;
          blank[B][0] = i;
          blank[B][1] = j;
        }
      }
    }
    
    // 벽을 3개 세우는 모든 방법 확인
    dfs(1, 0);

    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N+1][M+1];
    B = 0;
    blank = new int[N * M + 1][2]; // 총개수
    visit = new boolean[N+1][M+1];

    for(int i = 1; i <= N; i++) {
      String[] str = br.readLine().split(" ");
      for(int j = 1; j <= M; j++) {
        A[i][j] = Integer.parseInt(str[j-1]);
      }
    }

    pro();

    
  }
}
