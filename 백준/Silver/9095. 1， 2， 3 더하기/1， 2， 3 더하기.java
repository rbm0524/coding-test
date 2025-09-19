import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int T, target;
  static int[] Dy;

  static void preprocess() {
    Dy[1] = 1;
    Dy[2] = 2;
    Dy[3] = 4;

    for(int i = 4; i <= 11; i++) {
      Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());
    Dy = new int[12];

    preprocess();
    
    for(int i = 1; i <= T; i++) {
      target = Integer.parseInt(br.readLine());
      sb.append(Dy[target]).append("\n");
    }

    System.out.println(sb);
    
    
  }
}
