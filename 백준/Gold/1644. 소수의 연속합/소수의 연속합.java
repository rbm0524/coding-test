import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, cnt;
  static ArrayList<Integer> A;

  //소수인지 아닌지 판별
  static boolean valid(int num) {
    for(int i = 2; i <= (int)Math.sqrt(num); i++) {
      if(num % i == 0) return false;
    }
    return true;
  }
  
  static void pro() {
    int L = 0;
    int R = 0;
    int sum = 0;

    while(L < A.size() || R < A.size()) {
      if(R >= A.size()) {
        if(sum == N) {
          cnt++;
        } 
        sum -= A.get(L);
        L++;
        continue;
      }
      if(sum == N) {
        cnt++;
        sum -= A.get(L);
        L++;
      } else if(sum > N){
        sum -= A.get(L);
        L++;
      } else {
        sum += A.get(R);
        R++;
      }
    }

    System.out.println(cnt);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(br.readLine());
    A = new ArrayList<>();
    A.add(2);

    // 소수 모으기(이중FOR문 돌면 시간초과임)
    for(int i = 3; i <= N; i++) {
      if(valid(i)){
        A.add(i);
      }
    }

    pro();
    
    
  }
}
