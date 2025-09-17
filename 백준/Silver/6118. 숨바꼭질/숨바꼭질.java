import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
  static int N, M;
  static int[] A;
  static boolean[] visit;
  static int[] dist;

  static void dfs() {

    for(int i = 1; i <= N; i++) {
        dist[i] = -1;
    }

    dist[1] = 0;
    
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    visit[1] = true;

    while(!q.isEmpty()) {
      int cur = q.poll();

      for(int i : graph.get(cur)) {
        if(visit[i]) continue;
        q.offer(i);
        visit[i] = true;
        dist[i] = dist[cur] + 1;
      }
    }
    
  }
  
  static void pro() {
    dfs();

    // 최댓값 찾기
    int max = -1;
    int max_index = -1;
    int equal_count = 0;
    for(int i = 1; i <= N; i++) {
      if(dist[i] <= 0) continue;
      if(max < dist[i]) {
        max = dist[i];
        max_index = i;
      }
      
    }

    for(int i = 1; i <= N; i++) {
      if(max == dist[i]) equal_count++;
    }
    
    sb.append(max_index).append(" ").append(max).append(" ").append(equal_count);
    System.out.println(sb);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visit = new boolean[N+1];
    dist = new int[N+1];// 시작점(고정)부터 목적지(index)까지 거리

    for(int i = 1; i <= N; i++) {
      graph.put(i, new ArrayList<>());
    }
    
    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int ai = Integer.parseInt(st.nextToken());
      int bi = Integer.parseInt(st.nextToken());
      graph.get(ai).add(bi);
      graph.get(bi).add(ai);
    }

    pro();
    
  }
}
