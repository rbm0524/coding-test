import java.util.*;
import java.io.*;

public class Main{
  
  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] selected;

  static void rec_func(int k) {
    if(k == M+1) { // 다 골랐다.
      for(int i = 1; i <= M; i++) {
        sb.append(selected[i]).append(" ");
      }
      sb.append("\n");
    } else { // 아니면
      for(int cand = 1; cand <= N; cand++) {
        selected[k] = cand; // 현재 k index에 해당하는 곳에 cand를 넣고
        // k+1 ~ M까지 모두 탐색
        rec_func(k+1);
        //탐색 끝난 후에는 기록을 남길 필요가 없기 때문에 의례상 0으로 채우기
        selected[k] = 0;
      }
    }
  }
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selected = new int[M+1];

    rec_func(1); // 첫번째 원소부터 조건에 맞는 모든 방법 찾기

    System.out.println(sb);
    
  }
}
