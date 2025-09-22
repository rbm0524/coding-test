import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, n1, n2, ans;
  static boolean find = false;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  static void dfs(int x, int prev, int prev_sum) {
    
    for(int i : graph.get(x)) {
      if(i == prev) continue;
      if(i == n2) {
        find = true;
        ans = prev_sum+1;
        break;
      }
      dfs(i, x, prev_sum+1);
    }
    
  }
  
  static void pro() {
    dfs(n1, -1, 0);
    if(!find) ans = -1; 
    System.out.println(ans);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    ans = 0;
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    n1 = Integer.parseInt(st.nextToken());
    n2 = Integer.parseInt(st.nextToken());

    M = Integer.parseInt(br.readLine());

    for(int i = 1; i <= N; i++) {
      graph.put(i, new ArrayList<>());
    }

    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    pro();
    
    
  }
}
