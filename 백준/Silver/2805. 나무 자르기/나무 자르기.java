import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, M; // 나무의 수, 길이
  static int[] A;


  static void pro() {
    Arrays.sort(A, 1, N+1);

    // 여기서 L, R은 boolean 배열이 있다고 생각하고 index가 자를 높이를 정하는 것.
    long L = 0, R = 2_000_000_000, ans = 0; // 나무 길이 최대가 20억이라서 높이도 최대 20억

    while(L <= R) {
      long mid = (L+R) / 2;

      if(determination((int)mid)) { // M만큼 얻을 수 있으면 왼쪽을 당겨와서 높이를 높여봐야 함
        ans = mid;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }

    System.out.println(ans);

  }

  // H 높이로 나무를 잘랐을 때 M만큼 얻을 수 있으면 true, 없으면 false를 리턴
  static boolean determination(int H) {
    long sum = 0;
    for(int i = 1; i <= N; i++) {
      if(A[i] > H) {
        sum += A[i] - H;
      }
    }

    return sum >= M;
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    pro();
  }
}
