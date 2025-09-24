import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M, search;
  static int[] A;

  static int lower_bound() {
    int L = 1;
    int R = N;
    int result = 1;
    while(L <= R) {
      int mid = (L+R)/2;

      if(A[mid] >= search) { // 하한을 구한다.
        result = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }

    return result;
  }

  static int upper_bound() {
    int L = 1;
    int R = N;
    int result = N;
    while(L <= R) {
      int mid = (L+R)/2;

      if(A[mid] <= search) { // 상한을 구한다.
        result = mid;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }

    return result;
  }
  
  static void pro() {
    int lower_bound_index = lower_bound();
    int upper_bound_index = upper_bound();
    if(A[upper_bound_index] != search) {
      sb.append(0).append(" ");
      return;
    }

    sb.append(upper_bound_index - lower_bound_index + 1).append(" ");
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    A = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A, 1, N+1);

    M = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= M; i++) {
      search = Integer.parseInt(st.nextToken());
      pro();
    }

    System.out.println(sb);
    
  }
}
