import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M; // N : 세로, M : 가로
  static int[][] A;
  static int[][] visit_days;
  static int[][] dir = {{1, 0}, {0,1}, {-1,0}, {0,-1}};

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    //초기값 설정
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M ;j++) {
        if(A[i][j] == 1) {
          q.offer(i);
          q.offer(j);
          visit_days[i][j] = 0;
        }
      }
    }

    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();
      for(int i  = 0; i < 4; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];
        if(_x < 1 || _y < 1 || _x > N || _y > M) continue;
        if(A[_x][_y] == 0) { // 안익었을 때만 q에 추가
          A[_x][_y] = 1; //바꿔놓고 q에 추가
          visit_days[_x][_y] = visit_days[x][y]+1;
          q.offer(_x);
          q.offer(_y);
        }
      }
    }
  }
  
  static void pro() {
    bfs();
    int max_day = 0;
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        if(max_day < visit_days[i][j]) max_day = visit_days[i][j];
        if(A[i][j] == 0) {
          max_day = -1;
          System.out.println(max_day);
          return;
        }
      }
    }
    System.out.println(max_day);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    A = new int[N+1][M+1];
    visit_days = new int[N+1][M+1];

    
    for(int i = 1; i <= N; i++) {
      String[] s = br.readLine().split(" ");
      for(int j = 1; j <= M; j++)
      A[i][j] = Integer.parseInt(s[j-1]);
    }

    pro();
    
    
  }
}
