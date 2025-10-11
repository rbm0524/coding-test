import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K;
  static int[][] Dy;
  static int[] W;
  static int[] V;
  
  static void pro() {
    //초기값 설정
    for(int i = 0; i <= K; i++) {
      Dy[i][0] = 0; // 0번째 아이템은 존재하지 않으므로 0
    }

    for(int i = 0; i <= N; i++) {
      Dy[0][i] = 0; // 가방 무게 0일 때 가치
    }

    for(int i = 1; i <= K; i++) {
      for(int j = 1; j <= N; j++) {
        int weight = W[j]; // 현재 무게
        int value = V[j]; // 현재 가치

        if(i < weight) {
          Dy[i][j] = Dy[i][j-1];
        } else { // 넣을 수 있으면
          Dy[i][j] = Math.max(Dy[i-weight][j-1] + value, Dy[i][j-1]);
        }
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    Dy = new int[K+1][N+1]; // 버틸 수 있는 최대 무게로
    W = new int[N+1];
    V = new int[N+1];

    //무게와 가치 입력받기
    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      W[i] = w;
      V[i] = v;
    }

    pro();

    System.out.println(Dy[K][N]);
  }
}
