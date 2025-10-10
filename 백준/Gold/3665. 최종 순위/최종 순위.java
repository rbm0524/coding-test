import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T, N, M;
  static int[] indeg;
  static HashMap<Integer, ArrayList<Integer>> graph;
  static ArrayList<Integer> rank;

  // 사이클이 만들어지면 IMPOSSIBLE
  static void pro() {
    
    Queue<Integer> q = new LinkedList<>();
    ArrayList<Integer> sequence = new ArrayList<>();

    for(int i = 1; i <= N; i++) {
      if(indeg[i] == 0) {
        q.add(i);
      }
    }

    while(!q.isEmpty()) {
      if(q.size() > 1) {
        sb.append("?");
        return;
      }
      int k = q.poll();
      sequence.add(k);
      
      for(int i : graph.get(k)) {
        indeg[i]--;
        if(indeg[i] == 0) {
          q.add(i);
        }
      }
    }

    if(sequence.size() != N) {
        sb.append("IMPOSSIBLE");
        return;
    }
    
    for(int i : sequence) {
      sb.append(i).append(" ");
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());

    // st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= T; i++) {

      graph = new HashMap<>();

      N = Integer.parseInt(br.readLine());
      indeg = new int[N+1];

      st = new StringTokenizer(br.readLine());
      for(int j = 1; j <= N; j++) {
        int v1 = Integer.parseInt(st.nextToken());
        for(int k : graph.keySet()) {
          graph.get(k).add(v1);
          indeg[v1]++;
        }
        graph.put(v1, new ArrayList<>());
      }

      // 그래프 만들기
      M = Integer.parseInt(br.readLine());
      for(int j = 1; j <= M; j++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        //상대적 등수가 바뀐거지 2 4라고 해서 무조건 2가 먼저 온다는게 아님
        if(graph.get(v1).contains(v2)) { // v1 -> v2면
          // v1이 v2 앞에 오게 됐다.
          indeg[v1]++;
          indeg[v2]--;
          graph.get(v1).remove(Integer.valueOf(v2)); // Object를 삭제해야된다
          graph.get(v2).add(v1);
        } else { // v2 -> v1이면
          // v1이 v2 앞에 오게 됐다.
          indeg[v2]++;
          indeg[v1]--;
          graph.get(v2).remove(Integer.valueOf(v1)); // Object를 삭제해야된다
          graph.get(v1).add(v2);
        }
      }

      pro();
      sb.append("\n");
    }

    System.out.print(sb);
    
    
  }
}
