import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T, I, cnt, initial_x, initial_y, target_x, target_y;
  static int[][] A;
  static boolean[][] visit;
  static int[][] count;
  static int[][] dir = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    q.offer(initial_x);
    q.offer(initial_y);
    count[initial_x][initial_y] = 0;
    visit[initial_x][initial_y] = true;

    while(!q.isEmpty()) {
      int x = q.poll();
      int y = q.poll();
      for(int i = 0; i < 8; i++) {
        int _x = x + dir[i][0];
        int _y = y + dir[i][1];
        if(_x < 0 || _y < 0 || _x >= I || _y >= I) continue;
        if(visit[_x][_y]) continue;
        visit[_x][_y] = true;
        count[_x][_y] = count[x][y] + 1;
        q.offer(_x);
        q.offer(_y);
      }
      
    }
  }
  
  static void pro() {
    bfs();

    System.out.println(count[target_x][target_y]);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    //st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= T; i++) {
      I = Integer.parseInt(br.readLine());
      A = new int[I+1][I+1];
      count = new int[I+1][I+1];
      visit = new boolean[I+1][I+1];
      cnt = 0;
      st = new StringTokenizer(br.readLine());
      initial_x = Integer.parseInt(st.nextToken());
      initial_y = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      target_x = Integer.parseInt(st.nextToken());
      target_y = Integer.parseInt(st.nextToken());
      
      pro();
    }
  }
}
