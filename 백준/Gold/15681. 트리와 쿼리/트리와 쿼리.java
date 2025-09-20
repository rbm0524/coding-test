import java.io.*;
import java.util.*;

public class Main {

  static int N, R, Q, U;
  static ArrayList<Integer>[] tree;
  static int[] Dy;

  static StringBuilder sb = new StringBuilder();

  static void dfs(int x, int prev) {
    Dy[x] = 1; // root는 노드가 하나니까

    for (int y : tree[x]) {
      if (prev == y)
        continue;

      dfs(y, x);
      Dy[x] += Dy[y]; // 이전 노드는 현재 노드의 자식 갯수를 더한거구나. (거기에 기존 자기것까지 해서 트리의 노드 개수가 세어진다.)
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    tree = new ArrayList[N + 1];
    Dy = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      tree[i] = new ArrayList<>();
    }

    // 간선을 입력받을 거임 -> 정점개수-1 만큼 입력
    for (int i = 1; i <= N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      tree[v1].add(v2);
      tree[v2].add(v1);
    }

    dfs(R, -1);

    // 쿼리 수만큼 반복
    for (int i = 0; i < Q; i++) {
      U = Integer.parseInt(br.readLine());

      sb.append(Dy[U]).append("\n");
    }
    System.out.println(sb);
  }
}
