import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, ans, cnt;
  static boolean find = false;

  // N을 만드는 가장 작은 수 구하기
  static void rec_func(int k, int current_sum, int total_number) {
    if(k == cnt+1) { // 자리수를 벗어나면     
      if(current_sum == N) {
        find = true;
        ans = total_number;
      }
    } else {
      for (int i = 0; i <= 9 && !find; i++) {
        rec_func(k+1, current_sum+i*(int)Math.pow(10,cnt-k)+i, total_number+i*(int)Math.pow(10,cnt-k)); // 선택o
      }

    }
  }

  static void pro() {
    //자리수 구하기
    int copy_N = N;
    while(copy_N > 0) {
      copy_N /= 10;
      cnt++;
    }
    
    rec_func(1, 0, 0);
    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    pro();
    
    
  }
}
