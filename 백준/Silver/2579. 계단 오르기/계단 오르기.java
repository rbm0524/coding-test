import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[][] Dy;
  static int[] score;

  static void preprocess() {
    Dy[1][0] = 0; // 시작칸 안밟고 오는 경우는 없다.
    Dy[1][1] = score[1];

    if(N >= 2) {
        Dy[2][0] = score[2];
      Dy[2][1] = score[1] + score[2];
    }

    for(int i = 3; i <= N; i++) {
      Dy[i][0] = Math.max(Dy[i-2][0] + score[i], Dy[i-2][1] + score[i]); // 이전것을 밟지 않을 때
      Dy[i][1] = Dy[i-1][0] + score[i];
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    Dy = new int[301][301];
    score = new int[N+1];

    
    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      score[i] = Integer.parseInt(st.nextToken());
    }

    preprocess();

    System.out.println(Math.max(Dy[N][0], Dy[N][1]));
    
  }
}
