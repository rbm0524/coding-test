import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T,N,M,K,cnt;
  static int[][] A;
  static boolean[][] visit;
  static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

  static void bfs(int x, int y) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(x);
    q.offer(y);
    visit[x][y] = true;

    while(!q.isEmpty()) {
      int _x = q.poll();
      int _y = q.poll();
      for(int i = 0; i < 4; i++) {
        int cand_x = _x + dir[i][0];
        int cand_y = _y + dir[i][1];
        if(cand_x < 0 || cand_y < 0 || cand_x > N || cand_y > M) continue;
        if(A[cand_x][cand_y] == 0) continue;
        if(visit[cand_x][cand_y]) continue;
        visit[cand_x][cand_y] = true;
        q.offer(cand_x);
        q.offer(cand_y);
      }
    }
  }
  
  static void pro() {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(A[i][j] == 1 && !visit[i][j]) {
          bfs(i, j);
          cnt++;
        }
      }
    }
    System.out.println(cnt);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for(int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      cnt = 0;
      A = new int[N+1][M+1];
      visit = new boolean[N+1][M+1];
      for(int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        A[y][x] = 1;
      }
      pro();
    }
  }
}
