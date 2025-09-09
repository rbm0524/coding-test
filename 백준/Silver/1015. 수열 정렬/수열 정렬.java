import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static Elem[] B;
  static int[] P;

  static class Elem implements Comparable<Elem> {
    public int idx, num; // idx는 A 배열에서의 위치, num은 A에서 idx에 해당하는 값

    @Override
    public int compareTo(Elem other) {
      if(num != other.num) return num - other.num; // 비내림차순 : 사실상 오름차순
      return idx - other.idx; // 사전순 정렬
    }
  }

  static void pro() {
    Arrays.sort(B);

    for(int i = 0; i < N; i++) {
      int b_idx = B[i].idx;
      P[b_idx] = i;
    }
    
  }
  

  // 배열 B는 수열 P(아무튼 배열)를 index로 하는 위치에 A 배열의 값을 가진다.
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    B = new Elem[N];
    P = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      B[i] = new Elem();
      B[i].idx = i;
      B[i].num = Integer.parseInt(st.nextToken());
    }

    pro();

    for(int i : P) {
      sb.append(i).append(" ");
    }
    
    System.out.println(sb);
    
    
    
  }
}
