import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, C, cnt;
  static int[] A; // 용량 저장
  static ArrayList<Long> sum1 = new ArrayList<>();
  static ArrayList<Long> sum2 = new ArrayList<>();
  

  static void subSetsums(int index, int end, long currentSum, ArrayList<Long> sum) {
    if(index == end+1) { // 선택을 마치면
      sum.add(currentSum);
    } else {
      subSetsums(index+1, end, currentSum + A[index], sum); // 선택 했을 때
      subSetsums(index+1, end, currentSum, sum); // 선택 안 했을 때
    }
  }
  
  static void pro() {
    //부분합 구하기 (2개 더했을 때, 3개 더했을 때 ...)
    // 중복을 허용하지 않고 순서가 없는 배열에 대해 절반의 부분합 2번 구하기
    subSetsums(1, N/2, 0L, sum1);
    subSetsums(N/2+1, N, 0L, sum2);

    // 두 배열에 대해 투포인터
    Collections.sort(sum1);
    Collections.sort(sum2);
    
    // 두 부분합에 대해 정렬 후 가장 최소, 가장 최대를 찍고 target보다 작으면 최솟값을 늘려, target보다 크면 최댓값을 줄여
    int L = 0;
    int R = sum2.size()-1;
    while(L < sum1.size() && R >= 0) {
      if(sum1.get(L) + sum2.get(R) <= C) {
        L++;
        cnt+=R+1; // 0 ~ R까지 더해도 무조건 C보다 작거나 같으니까(투포인터!)
      } else if(sum1.get(L) + sum2.get(R) > C) {
        R--;
      }
    }

    System.out.println(cnt);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    A = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A, 1, N+1);

    pro();
    
    
  }
}
