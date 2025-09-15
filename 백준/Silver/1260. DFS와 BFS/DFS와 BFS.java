import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, V;
  static HashMap<Integer, ArrayList<Integer>> adj;
  static boolean[] visited;

  static void dfs(int x) {
    visited[x] = true;
    sb.append(x).append(" ");

    for(int i : adj.get(x)) {
      if(visited[i]) continue;
      dfs(i);
    }
  }

  static void bfs(int x) {
    Queue<Integer> q = new LinkedList<>();

    q.add(x);
    visited[x] = true;
    while(!q.isEmpty()) {
      int cur = q.poll();
      sb.append(cur).append(" ");

      for(int i : adj.get(cur)) {
        if(visited[i]) continue;

        visited[i] = true;
        q.offer(i);
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    adj = new HashMap<>();
    for(int i = 1; i <= N; i++) {
      adj.put(i, new ArrayList<>());
    }
    
    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      adj.get(v1).add(v2);
      adj.get(v2).add(v1);
    }

    for(int i = 1; i <= N; i++) {
      Collections.sort(adj.get(i));
    }

    visited = new boolean[N+1];
    dfs(V);
    sb.append("\n");
    visited = new boolean[N+1];
    bfs(V);
    System.out.println(sb);    
    
  }
}
 