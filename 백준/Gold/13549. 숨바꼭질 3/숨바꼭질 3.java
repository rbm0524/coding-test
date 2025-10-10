import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K, max;
  static int[] dist;
  static HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

  static class Edge {
    public int to, edge;

    Edge(){}

    Edge(int to, int edge) {
      this.to = to;
      this.edge = edge;
    }
  }
  
  static class Info {
    public int idx, sec;

    Info(){}

    Info(int idx, int sec) {
      this.idx = idx;
      this.sec = sec;
    }
  }

  static void dijkstra(int start) {

    for(int i = 0; i < dist.length; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    
    PriorityQueue<Info> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.sec));

    q.add(new Info(start, 0));
    dist[start] = 0;

    while(!q.isEmpty()) {
      Info info = q.poll();
      if(dist[info.idx] < info.sec) continue; // 꺼낸 것이 저장된 값보다 크면 무시

    // 그렇지 않으면 볼 가치가 있다.
      for(Edge e : graph.get(info.idx)) {
        if(dist[info.idx] + e.edge >= dist[e.to]) continue; // idx를 거쳐서 가는게 짧냐 vs 그 전의 최단거리가 짧냐
        dist[e.to] = dist[info.idx] + e.edge;
        q.add(new Info(e.to, dist[e.to]));
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    max = Math.max(N,K);
    dist = new int[max*2+1];

    //i에서 i-1, i+1, i*2까지 갈 수 있으면서 그에 대한 가중치 저장
    for(int i = 0; i <= max*2; i++) {
      ArrayList<Edge> add_edges = new ArrayList<>();
      if(i - 1 >= 0) {
        add_edges.add(new Edge(i-1, 1));
      }
      if(i+1 <= max*2) {
        add_edges.add(new Edge(i+1, 1));
      }
      if(i != 0 && i*2 <= max*2) {
        add_edges.add(new Edge(i*2, 0));
      }
      graph.put(i, add_edges);
    }

    dijkstra(N);
    System.out.println(dist[K]);
  }
}
