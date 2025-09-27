import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, min;
  static int[] A, count;
  static boolean[] visit;

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    visit[start] = true;

    while(!q.isEmpty()) {
      int cur = q.poll();

      for(int i = 1; i <= 6; i++) {
        if(cur + i > 100) continue;
        
        
        if(cur+i != A[cur+i]) { // 뱀이거나 사다리
          if(visit[A[cur+i]]) continue; // 이미 방문한 정점에 또 도달했다는건 count가 무조건 더 커진다는 것
          q.offer(A[cur+i]);
          visit[A[cur+i]] = true;
          visit[cur+i] = true; // 한 번 굴리는걸로 두 번 이동하니까
          count[cur+i] = count[cur] + 1;
          count[A[cur+i]] = count[cur] + 1; // 한 번 굴리기
        } else {
          if(visit[cur+i]) continue; // 이미 방문한 정점에 또 도달했다는건 count가 무조건 더 커진다는 것
          q.offer(cur+i);
          count[cur+i] = count[cur]+1;
          visit[cur+i] = true;
        }
        
      }
    }
    
  }
  
  static void pro() {
    bfs(1);
    System.out.println(count[100]);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[101];
    visit = new boolean[101];
    count = new int[101];

    for(int i = 1; i <= 100; i++) {
      A[i] = i;
    }
    
    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      A[x] = y; // 상승
    }

    for(int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      A[u] = v; // 하강
    }

    pro();
    
    
  }
}
