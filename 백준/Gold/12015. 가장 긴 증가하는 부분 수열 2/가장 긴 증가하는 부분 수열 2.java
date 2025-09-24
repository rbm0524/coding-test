import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, ans, kind;
  static int[] A;
  static ArrayList<Integer> temp;

  static void binary_search(int value) {

    // 비어있거나 마지막 값보다 value가 크면 그냥 add
    if(temp.isEmpty() || value > temp.get(temp.size()-1)) {
      temp.add(value);
    } else { // 아니면 이분 탐색으로 자리 찾아주기
        int L = 0;
        int R = temp.size() - 1;
        while(L < R) {
          int mid = (L+R)/2;
  
          if(temp.get(mid) >= value) { // 찾으려는 값보다 크거나 같은 부분들 중 하한을 본다.
            R = mid;
          } else {
            L = mid + 1;
          }
        }
        temp.set(R, value);
    }
  }
  
  static void pro() {
    temp = new ArrayList<>();
    for(int i = 1; i <= N; i++) {
      binary_search(A[i]);
    }
    ans = temp.size();
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    pro();

    System.out.println(ans);
    
    
  }
}
