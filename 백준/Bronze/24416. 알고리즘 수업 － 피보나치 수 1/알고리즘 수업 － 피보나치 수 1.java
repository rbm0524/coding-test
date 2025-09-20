import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] Dy;
  static int cnt = 0;

  // 호출 횟수가 아니라 덧셈 횟수임
  static int fib(int n) {
    if( n == 1 || n == 2) {
      return 1;
    }
    return fib(n-1) + fib(n-2);
  }
  
  static void preprocess() {
    Dy[1] = 1;
    Dy[2] = 1;
    
    for(int i = 3; i <= N; i++) {
      Dy[i] = Dy[i-1] + Dy[i-2];
      cnt++;
    }
  }
  
  static void pro() {
    preprocess();

    System.out.println(fib(N) + " " + cnt);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Dy = new int[N+1];

    pro();
  }
}
