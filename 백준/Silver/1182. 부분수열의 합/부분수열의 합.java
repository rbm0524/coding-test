import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, S, ans;
  static int[] nums;
  // 0 또는 1을 N번 나열, 중복을 허용하고, 순서가 있음(S가 되는 순간이 중요하기 때문)
  
  static void rec_func(int k, int value) { // k-1까지의 합을 계속 들고다니자
    if(k == N+1) {
      if(value == S) ans++;
    } else {
      rec_func(k+1, value + nums[k]); // k번째 원소를 포함시킴
      rec_func(k+1, value);// k번째 원소를 포함시키지 않음      
    }
  }

  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    nums = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    rec_func(1, 0);

    //'진 부분집합'만 다루는지 확인이 필요하다
    // 모두 포함시키지 않아서 합이 0이 되는 경우에도 S가 0이면 조건 만족이기 때문
    if(S == 0) ans--;
    System.out.println(ans);

    
  }
}
