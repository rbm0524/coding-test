import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, cnt, ans;
  static int k = 1;

  static void pro() {
    while(cnt != N) {
      if(Integer.toString(k).contains("666")) {
        cnt++;
        ans=k;
      }
      k++;
    }
    System.out.println(ans);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    
    pro();
  }
}
