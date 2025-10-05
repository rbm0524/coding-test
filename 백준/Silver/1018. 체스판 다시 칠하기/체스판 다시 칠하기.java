import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static String[] A;
  static String[] A_white, A_black;
  static int cnt1, cnt2;
  static int min = Integer.MAX_VALUE;

  static void rec_func(int x, int y, char start) {
    // 시작 문자와 상관없이 두 번 봐야한다. 
    for(int i = x; i < x + 8; i++) {
      for(int j = y; j < y + 8; j++) {
        if(A_white[i-x].charAt(j-y) != A[i].charAt(j)) {
          cnt1++;
        }
      }
    }
    
    for(int i = x; i < x+8; i++) {
      for(int j = y; j < y+8; j++) {
        if(A_black[i-x].charAt(j-y) != A[i].charAt(j)) {
          cnt2++;
        }
      }
    }
    
    min = Math.min(Math.min(cnt1, cnt2), min);
  }
  
  static void pro() {
    for(int i = 0; i < 8; i++) {
      if(i % 2 == 0) {
        A_black[i] = "BWBWBWBW";
        A_white[i] = "WBWBWBWB";
      } else {
        A_black[i] = "WBWBWBWB";
        A_white[i] = "BWBWBWBW";
      }
    }

    for(int i = 0; i < N && i + 7 < N; i++) {
      for(int j = 0; j < M && j + 7 < M; j++) {
        rec_func(i, j, A[i].charAt(j)); // 검사 시작 좌표
        cnt1 = 0;  
        cnt2 = 0;
      }
    }

    System.out.println(min);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new String[N+1];
    A_white = new String[8];
    A_black = new String[8];
    

    // st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      A[i] = br.readLine();
    }

    pro();
    
    
  }
}
