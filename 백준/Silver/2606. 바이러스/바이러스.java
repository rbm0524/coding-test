import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, cnt;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
  static boolean[] visit;

  static void dfs(int x) {
    
    for(int i : graph.get(x)) {
      if(visit[i]) continue;
      cnt++;
      visit[i] = true;
      dfs(i);
    }
  }
  
  static void pro() {
    visit[1] = true;
    dfs(1);
    System.out.println(cnt);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    visit = new boolean[N+1];

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
