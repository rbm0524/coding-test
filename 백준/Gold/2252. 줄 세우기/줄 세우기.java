import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static ArrayList<Integer>[] adj;
  static int[] indeg;
  static StringBuilder sb = new StringBuilder();

  static void pro() {
    // 덱(deque)는 양 끝에서 삽입 삭제 가능
    Deque<Integer> que = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indeg[i] == 0) { // 0인 것을 먼저 찾아서 큐에 넣는다
        que.add(i);
      }
    }

    while (!que.isEmpty()) {
      int x = que.poll();
      sb.append(x).append(" ");
      for (int y : adj[x]) {
        indeg[y]--; // x제거 -> 어차피 빠꾸 안치니까 x제거가 알아서 됨
        if (indeg[y] == 0) {
          que.add(y);
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    adj = new ArrayList[N + 1];
    indeg = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      adj[v1].add(v2);
      indeg[v2]++;
    }

    pro();

    System.out.println(sb);

  }
}
