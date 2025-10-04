import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int final_x, final_y, a, b, c, d, e, f;
  
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    f = Integer.parseInt(st.nextToken());

    int x = (c*e-b*f)/(a*e-b*d);
    int y = (d*c-a*f)/(b*d-a*e);
    System.out.println(x + " " + y);
  }
}
