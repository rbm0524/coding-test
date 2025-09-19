import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, start, end;
  static int[] dist;
  static HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

  // to까지 가는 간선의 현재 최소 가중치
  static class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static class Info {
    int idx;
    int weight;

    Info(int idx, int weight) {
      this.idx = idx;
      this.weight = weight;
    }
  }

  static void dijkstra(int start) {
    // 거리 초기화
    for(int i = 1; i <= N; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    //최소 힙 생성
    PriorityQueue<Info> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    q.offer(new Info(start, 0));
    dist[start] = 0;

    while(!q.isEmpty()) {
      Info current = q.poll();
      if(dist[current.idx] == current.weight) {
        for(Edge edge : graph.get(current.idx)) {
          if(dist[edge.to] <= dist[current.idx] + edge.weight) continue;
          int update_min = dist[current.idx] + edge.weight; 
          q.offer(new Info(edge.to, update_min));
          dist[edge.to] = update_min;
        }
      }
    }
  }
  
  static void pro() {
    dijkstra(start);

    System.out.println(dist[end]);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    dist = new int[N+1];

    for(int i = 1; i <= N; i++) {
      graph.put(i, new ArrayList<>());
    }
    
    StringTokenizer st;
    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      
      graph.get(from).add(new Edge(to, weight));
      
    }

    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    
    pro();
    
     
  }
}
