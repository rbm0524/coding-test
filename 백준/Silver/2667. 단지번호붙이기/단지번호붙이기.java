import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, group_cnt;
  static String[] a;
  static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
  static boolean[][] visited;
  static ArrayList<Integer> group = new ArrayList<>(); // 오름차순 정렬하려고

  // x, y를 갈 수 있다는 것을 알고 방문한 상태
  static void dfs(int x, int y) {
    group_cnt++;
    visited[x][y] = true;
    for(int i = 0; i < 4; i++) {
      int _x = x + dir[i][0];
      int _y = y + dir[i][1];

      if(_x >= N || _y >= N || _x < 0 || _y < 0) continue;

      if(!visited[_x][_y] && a[_x].charAt(_y) == '1') {
        dfs(_x, _y);
      }
    }
  }

  static void pro() {
    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        if(!visited[i][j] && a[i].charAt(j) == '1') {
          group_cnt = 0;
          dfs(i, j);
          group.add(group_cnt); // dfs끝나면 그룹 하나 생긴거니까 add
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    visited = new boolean[N+1][N+1];
    a = new String[N];

    
    for(int i = 0; i < N; i++) {
      a[i] = br.readLine();
    }

    pro();

    Collections.sort(group);
    sb.append(group.size()).append("\n");
    for(int i : group) {
      sb.append(i).append("\n");
    }

    System.out.println(sb);
    
  }
}
