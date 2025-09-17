import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static String[] A;
  static int[][] dist_water;
  static int[][] dist_hedgehog;
  static boolean[][] visit_water;
  static boolean[][] visit_hedgehog;
  static int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
  
  static void bfs_water() {

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        dist_water[i][j] = -1;
      }
    }
    
    Queue<Integer> q = new LinkedList<>();
    
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(A[i].charAt(j) == '*') {
          q.offer(i);
          q.offer(j);
          visit_water[i][j] = true;
          dist_water[i][j] = 0;
        }
      }
    }

    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();

      for(int i = 0; i < 4; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];

        if(_x < 0 || _y < 0 || _x >= N || _y >= M) continue;
        if(visit_water[_x][_y]) continue;
        if(A[_x].charAt(_y) != '.') continue;
        q.offer(_x);
        q.offer(_y);
        visit_water[_x][_y] = true;
        dist_water[_x][_y] = dist_water[x][y] + 1;
      }
    }
  }

  static void bfs_hedgehog() {

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        dist_hedgehog[i][j] = -1;
      }
    }
    
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {
        if(A[i].charAt(j) == 'S') {
          q.offer(i);
          q.offer(j);
          visit_hedgehog[i][j] = true;
          dist_hedgehog[i][j] = 0;
          break;
        }
      }
    }
    
    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();

      for(int i = 0; i < 4; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];

        if(_x < 0 || _y < 0 || _x >= N || _y >= M) continue;
        if(visit_hedgehog[_x][_y]) continue;
        if(A[_x].charAt(_y) != '.' && A[_x].charAt(_y) != 'D') continue; // *이거나 X면 건너뛰기
        // 애초에 물이 갈 수 없는 칸(D나 X가 있는 칸)이 있는데, 그런 칸은 무조건 <=에 걸려서 continue되니까 거르는 것
        // D로 가봐야되는데 continue에서 걸러지고 끝나면 그 칸은 -1로 남아서 아예 도달도 못하게 되는 것
        // 즉, 물이 도달하긴 했는데 그 타이밍이 고슴도치보다 빠른 것은 거르는 것이다.
        if(dist_water[_x][_y] != -1 && dist_water[_x][_y] <= dist_hedgehog[x][y] + 1) continue; // 이미 물이 있으면 못가니까
        q.offer(_x);
        q.offer(_y);
        visit_hedgehog[_x][_y] = true;
        dist_hedgehog[_x][_y] = dist_hedgehog[x][y] + 1;
      }
    }
    
  }
  
  static void pro() {
    bfs_water();
    bfs_hedgehog();

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M;j++) {
        if(A[i].charAt(j) == 'D') {
          if(dist_hedgehog[i][j] >= 0) {
            System.out.println(dist_hedgehog[i][j]);
          } else {
            System.out.println("KAKTUS");
          }
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new String[N];
    dist_water = new int[N][M];
    dist_hedgehog = new int[N][M];
    visit_water = new boolean[N][M];
    visit_hedgehog = new boolean[N][M];

    for(int i = 0; i < N; i++) {
      A[i] = br.readLine();
    }

    pro();
    
    
  }
}
