import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();

  static int N, M;
  static int[] selected;

  static void rec_func(int k) {
    if(k == M+1) {
      for(int i = 1; i <= M ; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else {
      for(int cand = 1; cand <= N; cand++) {
        if(selected[k-1] <= cand) selected[k] = cand;
        else continue;

        rec_func(k+1);
        selected[k] = 0;
        
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selected = new int[M + 1];

    rec_func(1);

    System.out.println(sb);
    
  }
}
