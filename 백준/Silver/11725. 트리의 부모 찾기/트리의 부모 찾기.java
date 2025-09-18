import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[] parent;
  static ArrayList<Integer>[] adj; // ArrayList를 원소로 가지는 배열!
  // static boolean[] visit;
  // 트리는 왔다갔다가 아니니까 visit이 필요없다!
  static StringBuilder sb = new StringBuilder();

  static void dfs(int x, int par) {
    for (int y : adj[x]) { // iterator!
      if (par != y) {
        parent[y] = x; // index의 부모를 저장
        dfs(y, x);
      }
    }

  }

  static void pro() {
    dfs(1, -1); // 초기 parent는 -1로

    for (int i = 2; i <= N; i++) {
      sb.append(parent[i]).append("\n");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    adj = new ArrayList[N + 1];
    parent = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<Integer>();
    }

    for (int i = 1; i <= N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      adj[v1].add(v2);
      adj[v2].add(v1);
    }

    pro();

    System.out.println(sb);

  }
}
