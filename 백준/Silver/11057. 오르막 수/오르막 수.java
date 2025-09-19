import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[][] Dy;

  static void preprocess() {
    for(int i = 0; i <= 9; i++) {
      Dy[1][i] = 1;
    }

    for(int i = 2; i <= N; i++) {
      for(int j = 0; j <= 9; j++) {
        for(int k = 0; k <= j; k++) {
          Dy[i][j] += Dy[i-1][k];
          Dy[i][j] %= 10007;
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Dy = new int[N+1][10];    

    preprocess();

    int ans = 0;

    for(int i  = 0; i <= 9; i++) {
        ans += Dy[N][i]; 
        ans %= 10007;
    }
    System.out.println(ans);
    
  }
}
