import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static int[] A;
  static StringBuilder sb = new StringBuilder();

  static void pro() {
    Arrays.sort(A, 1, N + 1);

    int best_sum = Integer.MAX_VALUE;
    int v1 = 0, v2 = 0, L = 1, R = N;

    while (L < R) {
      int sum = A[L] + A[R];
      if (Math.abs(sum) < best_sum) {
        best_sum = Math.abs(sum);
        v1 = A[L];
        v2 = A[R];
      }

      if (sum < 0) {
        L++;
      } else if (sum > 0) {
        R--;
      } else {
        break;
      }

    }
    sb.append(v1).append(' ').append(v2);

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    A = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    pro();

    System.out.println(sb);

  }
}
