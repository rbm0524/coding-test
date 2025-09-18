import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, root, erased;
  static int[] leaf;
  static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();

  static void dfs(int x) {
    if(tree.get(x).size() == 0) {
      leaf[x] = 1;
    }
    
    for(int i : tree.get(x)) {
      dfs(i);
      leaf[x] += leaf[i]; // 누적시키면 된다. bfs는 자식들이 자기보다 늦게 계산되니까 dfs를 쓰는 것
    }

    
  }
  
  static void pro() {
    // erased 정점 지우기
    for(int i : tree.keySet()) {
      tree.get(i).remove(Integer.valueOf(erased));
      //원시타입 int로 넘기면 index로 판단되고 Object타입을 넘기면 값으로 인식됨.
    }

    // root가 사라지면 빈 트리가 되니까 root가 살아있는 경우에만 dfs를 해본다.
    if(root != erased) {
      dfs(root);
    }

    System.out.println(leaf[root]);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    leaf = new int[N+1];
    String[] s = br.readLine().split(" ");

    for(int i = 0; i < N; i++) {
      tree.put(i, new ArrayList<>());
    }

    for(int i = 0; i < N; i++) {
      int parent = Integer.parseInt(s[i]);
      if(parent == -1) {
        root = i; // root는 부모가 없어서 기록하지 않도록 
        continue;
      }
      tree.get(parent).add(i); // child에서 부모로 돌아갈 필요가 없음. 어차피 leaf배열에 다 기록되니까. 그래서 방향 트리처럼
    }

    erased = Integer.parseInt(br.readLine());
      
    pro();
    
    
  }
}
