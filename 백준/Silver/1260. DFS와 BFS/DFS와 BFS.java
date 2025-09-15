import java.io.*;
import java.util.*;

public class Main {

  static int N, M, V;
  // static int[][] adj;// 인접 행렬로
  static ArrayList<Integer>[] adj; // ArrayList를 원소로 가지는 배열!
  static boolean[] visit; // default는 false
  static StringBuilder sb = new StringBuilder();

  static void dfs(int x) {
    visit[x] = true; // x를 방문한 상태니까
    sb.append(x).append(" "); // 처리
    for (int y : adj[x]) { // iterator!
      // if (adj[x][y] == 0) 0인 경우는 없을 것이니까 조건 검사 필요가 없음
      // continue;
      if (visit[y])
        continue;

      dfs(y);

    }

  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(start);
    visit[start] = true;

    while (!queue.isEmpty()) {
      int x = queue.poll(); // x를 방문한 상태
      sb.append(x).append(" ");

      for (int y : adj[x]) {
        if (visit[y])
          continue;
        queue.add(y);
        visit[y] = true;

      }
    }

  }

  static void pro() {
    visit = new boolean[N + 1];
    dfs(V);
    sb.append("\n");
    for (int i = 1; i <= N; i++)
      visit[i] = false;
    bfs(V);

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());
    // adj = new int[N + 1][N + 1];
    adj = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<Integer>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      adj[v1].add(v2);
      adj[v2].add(v1);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(adj[i]); // ArrayList는 Collections에서 sort
    }

    pro();

    System.out.println(sb);

  }
}
