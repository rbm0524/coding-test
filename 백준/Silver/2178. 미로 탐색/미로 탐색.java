import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[][] A;
  static boolean[][] visit;
  static int[][] dist;
  static int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

  static void pro() {
    Queue<Integer> q = new LinkedList<>();

    q.offer(1);
    q.offer(1);
    dist[1][1] = 1;
    visit[1][1] = true;

    while(!q.isEmpty()) {
      Integer x = q.poll();
      Integer y = q.poll();
      
      for(int i = 0; i < 4; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];
        if(_x < 1 || _y < 1 || _x > N || _y > M) continue;
        if(A[_x][_y] == 0) continue;
        if(visit[_x][_y]) continue;
        q.offer(_x);
        q.offer(_y);
        visit[_x][_y] = true;
        dist[_x][_y] = dist[x][y] + 1;
      }
    }

    System.out.println(dist[N][M]);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N+1][M+1];
    visit = new boolean[N+1][M+1];
    dist = new int[N+1][M+1];

    for(int i = 1; i <= N; i++) {
      String line = br.readLine();
      for(int j = 1; j <= M; j++) {
        
        A[i][j] = line.charAt(j-1) - '0';
      }
    }

    pro();
    
    
  }
}
