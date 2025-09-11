import java.io.*;
import java.util.*;

public class Main {

  static int N, S;
  static int[] A;
  static StringBuilder sb = new StringBuilder();

  static void pro() {
    int R = 0, sum = 0, ans = N + 1; // ans는 최소 길이 기록. 그래서 n+1로 설정해서 초기에는 무조건 갱신되도록 함
    for (int L = 1; L <= N; L++) {
      // L-1을 구간에서 제외
      sum -= A[L - 1];

      // R을 옮길 수 있을 때까지 옮기기
      // R의 오른쪽칸이 배열을 벗어나면 안된다
      while (R + 1 <= N && sum < S) {
        R++;
        sum += A[R];
      }

      // [L ... R]의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
      if(sum >= S) {
        ans = Math.min(ans, R-L+1);
      }

      //불가능 여부 판단
      if (ans == N+1) {// 한번도 갱신되지 않았다면
        ans=0;
      }

    }
    sb.append(ans);

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    A = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    
    pro();

    System.out.println(sb);

  }
}
