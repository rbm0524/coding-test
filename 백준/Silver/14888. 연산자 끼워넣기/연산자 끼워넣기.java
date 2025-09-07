import java.io.*;
import java.util.*;

public class Main {

  static int N, max, min;
  static int[] nums, operators, order; //
  static StringBuilder sb = new StringBuilder();

  static int calculator() {
    // nums, order
    int value = nums[1];
    for (int i = 1; i <= N - 1; i++) { // N-1개의 연산자를 사용
      if (order[i] == 1) {
        value = value + nums[i + 1];
      }

      if (order[i] == 2) {
        value = value - nums[i + 1];
      }

      if (order[i] == 3) {
        value = value * nums[i + 1];
      }

      if (order[i] == 4) {
        value = value / nums[i + 1];
      }
    }
    return value;
  }

  // order[1...N-1]에 연산자들이 순서대로 저장될 것
  static void rec_func(int k) {
    if (k == N) { // 연산자 나열을 전부 한 상태면 정답을 갱신하자
      int value = calculator();
      max = Math.max(max, value);
      min = Math.min(min, value);
    } else { // 나열을 덜했으면 나열하자, K번째 연산자는 무엇을 선택할 것인가?
      // 4가지 연산자들 중에 뭘 쓸 것인지 선택, 재귀호출하기
      for (int cand = 1; cand <= 4; cand++) {
        if (operators[cand] > 0) {
          operators[cand]--; // 하나 썼으니까
          order[k] = cand;
          rec_func(k + 1);
          operators[cand]++;
          order[k] = 0;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;
    // start input

    N = Integer.parseInt(br.readLine());
    nums = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    operators = new int[5]; // 연산자는 4개니까
    order = new int[N + 1]; // 수열개수만큼 연산자 나열할거니까
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= 4; i++) {
      operators[i] = Integer.parseInt(st.nextToken());
    }

    // start solve
    rec_func(1); // k = 1부터 시작
    sb.append("").append(max).append('\n').append(min);
    System.out.println(sb);

  }
}
