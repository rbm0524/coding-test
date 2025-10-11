import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[][] Dy;

  static final int MOD = 1000000000;

  static void pro() {
    for(int i = 1; i <= 9; i++) {
      Dy[1][i] = 1;
    }

    for(int i = 2; i <= N; i++) {
      for(int j = 0; j <= 9; j++) {
        if(j == 0) {
          Dy[i][j] = Dy[i-1][j+1] % MOD;
        } else if(j == 9) {
          Dy[i][j] = Dy[i-1][j-1] % MOD;
        } else {
          Dy[i][j] = (Dy[i-1][j+1] + Dy[i-1][j-1]) % MOD;
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Dy = new int[101][10];

    pro();
    
    long sum = 0;
    for(int i = 0; i <= 9; i++) {
      sum += Dy[N][i];
      sum %= MOD;
    }
    System.out.println(sum);
  }
}
