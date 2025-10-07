import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] A;
  static String line;
  static int length;
  static char[] c;

  static void pro(int start, int length) {
    if(length < 3) {
      return;
    }
    for(int i = start + (length/3); i <= start+(length/3*2-1); i++) {
      c[i] = ' ';
    }
    pro(start, length / 3);
    pro(start+length/3*2, length/3);
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //  st = new StringTokenizer(br.readLine());
    
    while((line = br.readLine()) != null) {
      length = (int)Math.pow(3,Integer.parseInt(line)); // 3^N을 입력받음
      c = new char[length+1];
      for(int i = 1; i <= length; i++) {
        c[i] = '-';
      }
      pro(1, length);
      sb.append(c, 1, length).append("\n");
    }
    System.out.println(sb);   
  }
}
