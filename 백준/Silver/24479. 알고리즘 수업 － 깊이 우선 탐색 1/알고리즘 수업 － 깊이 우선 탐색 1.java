import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, R;
  static boolean[] visit;
  static int[] sequence;
  static int cnt = 1;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  static void dfs(int x, int prev) {
    visit[x] = true;
    sequence[x] = cnt++;
    
    for(int i : graph.get(x)) {
      if(i == prev) continue;
      if(visit[i]) continue;
      dfs(i, x);
    }
  }
  
  static void pro() {
    for(int i : graph.keySet()) {
      Collections.sort(graph.get(i));
    }
    
    dfs(R, -1);
    for(int i = 1; i <= N; i++) {
      sb.append(sequence[i]).append("\n");
    }
    System.out.println(sb);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    visit = new boolean[N+1];
    sequence = new int[N+1];

    for(int i = 1; i<= N; i++) {
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
