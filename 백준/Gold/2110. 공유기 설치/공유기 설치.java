import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, C; // 집 개수, 공유기 개수
  static int[] A;

  static void pro() {
    Arrays.sort(A, 1, N+1);

    int L = 0;
    int R = 1_000_000_000;
    int ans = 0;

    while(L <= R) {
      int mid = (L+R) / 2;
      if(determination(mid)) {
        ans = mid;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    
    System.out.println(ans);
  }

  static boolean determination(int d) {
    
    // D만큼의 거리차이를 두면 공유기를 모두 설치할 수 있는가
    // D만큼의 거리를 두면서 최대로 일단 설치, 이후 C와 비교

    int cnt = 1, last = A[1]; // 일단 1번집에 설치

    for(int i = 2; i <= N; i++) {
      if(A[i] - last >= d) {
        cnt++;
        last = A[i]; // 공유기 설치한 마지막 집을 업데이트 
      }
    }
    
    return cnt >= C;
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }

    pro();
    
  }
}
