import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T;
  static String S;
  static int cnt;

  static int rec_func(int start, int end) {
    cnt++;
    if(start >= end) { // 어차피 같다.
      return 1;
    } else if (S.charAt(start) == S.charAt(end)) {
      return rec_func(start + 1, end - 1);
    }
    return 0;
  }

  static void pro() {
    System.out.println(rec_func(0, S.length()-1) + " " + cnt);
    cnt = 0;
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());

    for(int i = 1; i <= T; i++) {
      S = br.readLine();
      pro();
    }
  }
}
