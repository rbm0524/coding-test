import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] A;
  static int neareast;

  static void rec_func(int k, int current_sum, int cnt) {
    if(cnt == 3) {
      if(current_sum <= M && current_sum > neareast) {
        neareast = current_sum;
      }
    } else {
      if(k >= N+1) return;
      rec_func(k+1, current_sum+A[k], cnt + 1);
      rec_func(k+1, current_sum, cnt);
    }
  }
  
  static void pro() {
    rec_func(1, 0, 0);
    System.out.println(neareast);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    pro();
    
    
  }
}
