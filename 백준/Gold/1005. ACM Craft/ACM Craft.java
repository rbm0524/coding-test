import java.io.*;
import java.util.*;

public class Main {

  static int T,N,K,W;
  static ArrayList<Integer>[] adj;
  static int[] indeg, T_done, T_time;
  static StringBuilder sb = new StringBuilder();

  static void pro() {
    // 덱(deque)는 양 끝에서 삽입 삭제 가능
    Deque<Integer> que = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indeg[i] == 0) { // 0인 것을 먼저 찾아서 큐에 넣는다
        que.add(i);
        T_done[i] = T_time[i]; // 최초 0은 자기 시간만큼이 소요시간!
      }
    }

    while (!que.isEmpty()) {
      int x = que.poll();
      for(int y : adj[x]) {
        indeg[y]--;
        if(indeg[y] == 0) que.add(y);

        T_done[y] = Math.max(T_done[y], T_done[x] + T_time[y]);
        //기존 기대하던 종료 시간 vs x가 끝나고 나서 내가 건설되는 시간
        //아마 기존 기대하던 종료시간은 0일거임. 이제 계산해야되는 타이밍이니까. 따라서 갱신의 목적임!
      }
      
    }
    System.out.println(T_done[W]); //짓고싶은 건물의 시간 출력
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    
    for (int i = 1; i <= N; i++) {
      adj[i] = new ArrayList<Integer>();
    }

    for(int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      adj = new ArrayList[N + 1];

      for(int j = 1; j <= N; j++) {
        adj[j] = new ArrayList<Integer>();
      }
      
      indeg = new int[N + 1];
      T_done = new int[N + 1];
      T_time = new int[N + 1];

      st = new StringTokenizer(br.readLine());
      for(int j = 1; j <= N; j++) {
        T_time[j] = Integer.parseInt(st.nextToken());
      }
      
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        adj[v1].add(v2);
        indeg[v2]++;
      }

      W = Integer.parseInt(br.readLine());
      
      pro();
    }



    System.out.println(sb);

  }
}
