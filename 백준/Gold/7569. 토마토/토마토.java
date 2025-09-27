import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int M, N, H, days;
  static HashMap<Integer, ArrayList<Integer>> graph;
  static int[][] dir = {{0,0,1},{0,0,-1},{-1,0,0},{1,0,0},{0,1,0},{0,-1,0}};
  static int[][][] A;
  static int[][][] ripe;

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    //초기값 설정
    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        for(int k = 1; k <= H; k++) {
          if(A[i][j][k] == 1) {
            q.offer(i);
            q.offer(j);
            q.offer(k);
          }
        }
      }
    }
  

    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();
      int z = q.poll();

      for(int i = 0; i < 6 ; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];
        int _z = z + dir[i][2];
        if(_x < 1 || _y < 1 || _z < 1 || _x > N || _y > M || _z > H) continue;
        //A에 0이 저장된 곳은 방문하지 않은 것
        // -1이 저장된 곳은 토마토가 없는 칸
        if(A[_x][_y][_z] == -1 || A[_x][_y][_z] == 1) continue;
        q.offer(_x);
        q.offer(_y);
        q.offer(_z);
        A[_x][_y][_z] = 1;
        ripe[_x][_y][_z] = ripe[x][y][z] + 1;
        if(days < ripe[_x][_y][_z]) days = ripe[_x][_y][_z];
      }
    }
  }
  
  static void pro() {
    bfs();

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= M; j++) {
        for(int k = 1; k <= H; k++) {
          if(A[i][j][k] == 0) {
            days = -1;
            break;
          }
        }
      }
    }

    System.out.println(days);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    A = new int[N+1][M+1][H+1];
    ripe = new int[N+1][M+1][H+1];

    //st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= H; i++) {
      for(int j = 1; j <= N; j++) {
        String[] s = br.readLine().split(" ");
        for(int k = 1; k <= M; k++) {
          A[j][k][i] = Integer.parseInt(s[k-1]);
        }
      }
    }

    pro();
    
    
  }
}
