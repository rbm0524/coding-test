import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] A;
  static int[][] Dy;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  static void dfs(int x, int prev) {
    
    Dy[x][0] = 0;
    Dy[x][1] = A[x];

    for(int i : graph.get(x)) {
      if(i == prev) continue;
      dfs(i, x);
      Dy[x][0] += Math.max(Dy[i][1], Dy[i][0]);
      Dy[x][1] += Dy[i][0];
    }
  }
  
  static void pro() {
    dfs(1, -1);

    System.out.println(Math.max(Dy[1][0], Dy[1][1]));
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    A = new int[N+1];
    Dy = new int[N+1][2]; // 선택or선택x니까 2칸으로 충분
    
    for(int i = 1; i <= N; i++) {
      graph.put(i, new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i<= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i = 1; i <= N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    pro();
  }
}
