import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] Dy;

  static StringBuilder sb = new StringBuilder();

  static void preprocess() {
    // 초기화
    Dy = new int[1001];
    Dy[1] = 1;
    Dy[2] = 2;

    // 점화식
    for (int i = 3; i <= n; i++) {
      Dy[i] = (Dy[i - 1] + Dy[i - 2]) % 10007;
    }

  }

  static void pro() {

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    preprocess();

    sb.append(Dy[n]);

    System.out.println(sb);

  }
}
