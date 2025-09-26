import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int K, V, E;
  static HashMap<Integer, ArrayList<Integer>> graph;
  static boolean[] visit;
  static int[] color;


  static boolean bfs(int start) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    color[start] = 1;

    while(!q.isEmpty()) {
      int cur = q.poll();
      
      // 기록하려는 색
      int another_color = 1;
      if(color[cur] == 1) another_color = -1;
      
      for(int i : graph.get(cur)) {
        if(color[i] == 0)  { // 방문 안한 점에 대해
          q.offer(i);
          color[i] = another_color;
        } else { // 이미 방문한 점이면
          if(color[cur] == color[i]) return false; // 넣으려는 색과 이미 같은 색이 있으면 false
        }

      }
    }

    return true;
  }
  
  static void pro() {
    boolean valid = true;
    for(int i = 1; i <= V; i++) {
      if(color[i] != 0) continue;
      if(!bfs(i)) { // 유효하지 않으면
        valid = false;
        break;
      }
    }

    if(valid) {
      sb.append("YES").append("\n");
    } else {
      sb.append("NO").append("\n");
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    K = Integer.parseInt(br.readLine());
    
    for(int i = 1; i <= K; i++) {
      st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      
      graph = new HashMap<>();
      visit = new boolean[V+1];
      color = new int[V+1];
      for(int j = 1; j <= V; j++) {
        graph.put(j, new ArrayList<>());
      }

      for(int j = 1; j <= E; j++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        graph.get(from).add(to);
        graph.get(to).add(from);
      }

      pro();
    }

    System.out.println(sb);
    
  }
}
