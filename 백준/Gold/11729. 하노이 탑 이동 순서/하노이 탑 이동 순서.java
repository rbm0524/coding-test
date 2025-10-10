import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K;

  // 어디에서 어디로인지 파악하기
  // start에서 mid로 옮긴 후 마지막 하나 end로 옮기기
  // 나머지 전부 end로 하나씩 옮기기
  // start에서 end로 옮긴다. 남은 장대가 mid역할을 한다.
  static void pro(int num, int start, int mid, int end) {
    K++;
    if(num == 1) {
      sb.append(start).append(" ").append(end).append("\n");
      return;
    }
    pro(num-1, start, end , mid);
    sb.append(start).append(" ").append(end).append("\n");
    pro(num-1, mid, start, end);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());

    pro(N, 1, 2, 3);
    sb.insert(0, K + "\n");
    System.out.println(sb);
    
    
  }
}
