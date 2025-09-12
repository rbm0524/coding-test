import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] A;
  static int[] cnt = new int[100001];

  static void pro() {
    long ans = 0;

    for(int L = 1, R = 0; L <= N; L++) {
      // R을 옮길 수 있는 만큼 옮긴다.
      while(R + 1 <= N && cnt[A[R+1]] == 0) { // 옮길 수 있는지 체크할 때 배열 범위 체크 꼭
        R++;
        cnt[A[R]]++;
      }
      // 정답 갱신
      ans += R-L+1;

      // L을 옮기고, cnt[L]의 개수를 감소 (옮기는 것은 for문에 있으니 여기서는 옮기는게 아니다)
      cnt[A[L]]--;
    }

    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());    
    A = new int[N+1];
    
    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    pro();
    
  }
}
