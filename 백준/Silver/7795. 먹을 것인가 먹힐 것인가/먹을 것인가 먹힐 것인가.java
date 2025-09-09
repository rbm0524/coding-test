import java.io.*;
import java.util.*;

public class Main {

  static int T, N, M;
  static int[] A, B;
  static StringBuilder sb = new StringBuilder();

  static int lower_bound(int[] A, int L, int R, int X) { // X가 찾으려는 값
    // L~R에서 X보다 작은 수 중 가장 큰 수의 인덱스를 return
    // 그런게 없다면 L-1을 return
    int result = L - 1; // while에서 안걸렸을 때 이게 리턴될 것이니까
    while (L <= R) {
      int mid = (L + R) / 2;
      if (A[mid] < X) {
        result = mid;
        L = mid + 1;
      } else if (A[mid] >= X) {
        R = mid - 1;
      }
    }
    return result; // while에서 아무것도 안걸리거나 L > R이 되는 순간의 result를 리턴
  }

  static void pro() {
    Arrays.sort(B, 1, M + 1); // 0~M-1까지 정렬

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      ans += lower_bound(B, 1, M, A[i]);
    }
    sb.append(ans).append("\n");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      A = new int[N + 1];
      B = new int[M + 1];

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        A[j] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        B[j] = Integer.parseInt(st.nextToken());
      }

      pro();

    }

    System.out.println(sb);

  }
}
