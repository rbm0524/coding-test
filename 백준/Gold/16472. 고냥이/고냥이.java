import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, kind;
  static String A;
  static int[] cnt = new int[27];

  static void add(char x) { // x라는 알파벳 추가
    cnt[x-'a']++; // x는 char니까
    if(cnt[x-'a'] == 1) kind++; // 종류 추가( 1보다 큰 경우는 같은 종류니까 고려x)
  }

  static void erase(char x) { // x라는 알파벳 제거
    cnt[x-'a']--;
    if(cnt[x-'a'] == 0) kind--;
  }
  
  static void pro() {
    int length = A.length(); // 9
    int ans = 0;

    // 상황에 따라 L을 기준으로 할 수도, R을 기준으로 할 수도
    for(int L = 0, R = 0; R < length; R++) {
      // R번째 문자를 오른쪽에 추가
      add(A.charAt(R));

      // 불가능하면, 가능할 때까지 `L을 이동`
      while(true) {
        kind = 0;
        for(int i = 0; i < 26; i++) {
          if(cnt[i] != 0) kind++; // 0이 아니면 나왔던거니까 kind를 ++
        }
        if(kind <= N) { // kind가 N보다 작으면 구간 길이를 세봐야 하니까 break;
          break;
        }
        //아니면 L을 당겨와야 하니까 
        erase(A.charAt(L));
        L++;
      }

      ans = Math.max(ans, R - L + 1); // 구간 길이가 곧 최대길이
    }

    System.out.println(ans);
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    A = br.readLine();
    
    pro();
    
  }
}
