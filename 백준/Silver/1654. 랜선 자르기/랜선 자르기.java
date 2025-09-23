import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int K, N;
  static long ans;
  static int[] A;

  static void binary_search(long L, long R) {
    while(L <= R) {
      long mid = (L+R)/2; // mid 자체가 자를 길이
      long count = 0;
      for(int i = 1; i <= K; i++) {
        count += A[i]/mid;
      }
      if(count >= N) {
        ans = mid;
        L = mid + 1; // 더 길게 잘라보기
      } else {
        R = mid-1; // 더 짧게 잘라보기
      }
    }
  }
  
  static void pro() {

    Arrays.sort(A, 1, K+1);
    long max = A[K];

    binary_search(1L, max);

    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    A = new int[K+1];

    for(int i = 1; i <= K; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }

    pro();
    
    
  }
}
