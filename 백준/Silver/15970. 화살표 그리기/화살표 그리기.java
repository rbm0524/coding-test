import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static ArrayList<Integer>[] a;
  static int sum;
  
  static void pro() {
    // 색깔별 정렬
    for(int i = 1; i <= N; i++) {
      Collections.sort(a[i]);
    }

    // 가까운 점 찾기
    for(int color = 1; color <= N; color++) {
      for(int i = 0; i < a[color].size(); i++) {
        int Left = toLeft(color, i);
        int Right = toRight(color, i);
        sum += Math.min(Left, Right);
      }
      
    }
  }

  // 왼쪽에 점이 있으면 그 길이 리턴, 없으면 무한대를 리턴한다.(최소 거리 비교에서 유용)
  static int toLeft(int color, int idx) {
    if(idx == 0) {
      return Integer.MAX_VALUE;
    }
    return a[color].get(idx) - a[color].get(idx-1);
  }

  // 오른쪽에 점이 있으면 그 길이 리턴, 없으면 무한대를 리턴한다.
  static int toRight(int color, int idx) {
    if(idx+1 == a[color].size()) { // 오른쪽에 점이 없다. 
      return Integer.MAX_VALUE;
    }
    return a[color].get(idx+1) - a[color].get(idx);
  }
  
  @SuppressWarnings("unchecked")
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    /*
      Note: Main.java uses unchecked or unsafe operations.
      Note: Recompile with -Xlint:unchecked for details.
      제네릭 배열 생성을 원칙적으로 허용하지 않음.
      그래서 @SuppressWarnings("unchecked")
    */
    a = new ArrayList[N+1];

    for(int i = 1; i<=N; i++) {
      a[i] = new ArrayList<Integer>();
    }

    for(int i = 1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()); // 좌표
      int y = Integer.parseInt(st.nextToken()); // 색깔
      a[y].add(x);
    }

    pro();

    System.out.println(sum);

  }
}
