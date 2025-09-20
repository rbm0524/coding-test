import java.util.*;
import java.io.*;

//임시파일의 총 크기
public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T, K;
  static int[] A;
  static int[][] Dy, Sum;

  static void pro() {
    //Sum 초기화
    Sum = new int[K + 1][K+1];
    for(int i = 1; i <= K; i++) {
      for(int j = i; j <= K; j++) {
        Sum[i][j] = Sum[i][j-1] + A[j];
      }
    }

    Dy = new int[K+1][K+1];
    // 구간의 길이가 1일 때는 어차피 0으로 차있으니 2부터 시작
    for(int len = 2; len <= K; len++) {
      for(int i = 1; i <= K-len+1; i++) {
        int j = i + len -1; //구간이 끝나는 위치

        //Dy[i][j] 구하기 (i~j까지 합한 것)
        Dy[i][j] = Integer.MAX_VALUE; // 작은 값 가져다 쓸거니까 최댓값으로 초기화

        for(int k = i; k < j; k++) {
          Dy[i][j] = Math.min(Dy[i][j], Dy[i][k] + Dy[k+1][j] + Sum[i][j]); // 원래 알고 있던 값과 비교
        }
      }
    } 

    
    System.out.println(Dy[1][K]);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());

    for(int i = 1; i <= T; i++) {
      st = new StringTokenizer(br.readLine());
      K = Integer.parseInt(st.nextToken());
      A = new int[K+1];

      st = new StringTokenizer(br.readLine());
      for(int j  = 1; j <= K; j++) {
        A[j] = Integer.parseInt(st.nextToken());
      }
      
      pro();
    }
    
    
  } 
}
