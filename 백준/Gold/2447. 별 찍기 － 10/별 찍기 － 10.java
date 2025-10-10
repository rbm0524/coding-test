import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;

  static void pro(int i, int j, int num) {
    if((i / num) % 3 == 1 && (j / num) % 3 ==1 ) {
      sb.append(" ");
    } else {
      if(num / 3 == 0) { // num이 최소단위일 때(3x3일 때)
        sb.append("*");
      } else { // 그게 아니면 재귀로 최소단위까지 줄여서 재검사
        pro(i, j, num/3);
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        pro(i, j, N);
      }
      sb.append("\n");
    }

    System.out.println(sb);
    
    
  }
}
