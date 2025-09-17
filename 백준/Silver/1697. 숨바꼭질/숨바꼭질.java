import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K;
  static int[] dist;
  static boolean[] visit;
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.offer(N);
    visit[N] = true;

    while(!q.isEmpty()) {
      int cur = q.poll();
      if(cur == K) break;

      for(int i : graph.get(cur)) {
        if(visit[i]) continue;
        q.offer(i);
        visit[i] = true;
        dist[i] = dist[cur] + 1;
      }
    }
    
  }
  
  static void pro() {
    bfs();

    System.out.println(dist[K]);// K까지의 거리니까(BFS하면 최단거리 찾을 수 있어서 바로 O(1)로 찍는 것)
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dist = new int[100_001];
    visit = new boolean[100_001];

    for(int i = 0; i <= 100_000; i++) {
      graph.put(i, new ArrayList<>());
    }

    for(int i = 0; i <= 100_000; i++) {
      int back = i-1;
      int front = i+1;
      int multiple = i*2;

      if(back >= 0) graph.get(i).add(back);
      if(front <= 100_000) graph.get(i).add(front);
      if(multiple <= 100_000) graph.get(i).add(multiple);
    }

    pro();
    
    
  }
}
