import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, max;
  static long[] card;
  

  static void pro() {
    Arrays.sort(card, 1, N+1); // 1 ~ N까지 정렬

    long mode = card[1]; // 최빈값
    int modeCnt = 1, curCnt = 1; // 최빈값이 나온 횟수, 현재값이 나온 횟수

    for(int i = 2; i <= N; i++) {
      if(card[i] == card[i-1]) {
        curCnt++;
        if(modeCnt < curCnt) {
          modeCnt = curCnt;
          mode = card[i];
        }
      } else {
        curCnt = 1;
      }
    }

    System.out.println(mode);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    card = new long[N+1];

    for(int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      card[i] = Long.parseLong(st.nextToken());
    }

    pro();
    
  }
}
