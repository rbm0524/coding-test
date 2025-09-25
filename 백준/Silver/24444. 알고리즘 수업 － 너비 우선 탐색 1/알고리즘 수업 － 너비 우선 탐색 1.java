import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, R, num;
  static int[] sequence;
  static boolean[] visit;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();

    q.offer(R);
    visit[R] = true;

    while(!q.isEmpty()) {
      int cur = q.poll();
      sequence[cur] = ++num;
      for(int i : graph.get(cur)) {
        if(visit[i]) continue;
        q.offer(i);
        visit[i] = true;
      }
    }
    
  }

  static void pro() {
    bfs();

    for(int i = 1; i <= N; i++){
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
    sequence = new int[N+1];
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

    for(int i = 1; i <= N; i++) {
      Collections.sort(graph.get(i));
    }
    
    pro();
  }
}
