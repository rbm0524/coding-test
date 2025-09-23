import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K;
  static long ans;
  static long[][] A;
  static long[] B;

  static boolean determination(long mid) {
    long sum = 0;
    for(int i = 1; i <= N; i++) { // NxN 배열의 i번째 행에서 mid보다 작거나 같은 수의 개수를 세자
      sum += Math.min(N, mid/i);
      // ex) 5x5배열이고, 3번째 행에서 12보다 작거나 같은 수를 찾기
      // 3*j <= 12인 수를 찾으면 된다.
      // 여기서 j가 곧 mid/i가 되는 것. j번째 열까지 i*j한 것이 12보다 작으며 j가 곧 가능한 개수가 된다.
    }
    return sum >= K;
  }

  static void pro() {
    long L = 1;
    long R = (long)N*N;
    while(L <= R) {
      long mid = (L+R)/2;
      if(determination(mid)) {
        ans = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }

    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    pro();
    
    
  }
}
