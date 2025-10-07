import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, k;
  static int cnt = Integer.MAX_VALUE;

  static void pro() {

    for(int i = 0; i <= N/5; i++) {
      for(int j = 0; j <= N/3; j++) {
        if(5*i + 3*j == N) {
          if(cnt > i + j) {
            cnt = i + j;
          }
        }
      }
    }

    if(cnt == Integer.MAX_VALUE) {
      System.out.println(-1);
      return;
    }
    System.out.println(cnt);    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    pro();
  }
}
