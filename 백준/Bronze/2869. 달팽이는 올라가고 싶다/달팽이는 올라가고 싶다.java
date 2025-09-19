import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int A,B,V;
  static int current_height = 0;
  static int days = 1;

  // 결국에는 V-A에 도달하는데 며칠 걸리냐
  static void pro() {
    int up = A-B;
    days += (V-A) / up;
    if((V-A) % up != 0) {
      days++;
    }
    
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    pro();

    System.out.println(days);
    
  }
}
