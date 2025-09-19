import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] A;

  static void pro() {
    A[0] = 0;
    A[1] = 1;
    
    for(int i = 2; i <= N; i++) {
      A[i] = A[i-1] + A[i-2];
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    pro();

    System.out.println(A[N]);
    
  }
}
