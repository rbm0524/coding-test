import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] A;

  static boolean func(int target_idx) {
    int L = 1, R = N;
    int target = A[target_idx];
    while(L < R) {
      if(L == target_idx) {
        L++;
        continue;
      } else if(R == target_idx) {
        R--;
        continue;
      }
      
      if(A[L] + A[R] > target) {
        R--;
      } else if (A[L] + A[R] < target) {
        L++;
      } else {
        return true;
      }
    }

    return false;
  }
  
  static void pro() {
    int ans = 0;

    Arrays.sort(A, 1, N+1);
    
    for(int target = 1; target <= N; target++) {
      if(func(target)) {
        ans++;
      }
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
