import java.util.*;
import java.io.*;

public class Main{

  static class Elem implements Comparable<Elem> {
    String name;
    int korean, english, math;

    Elem(String name, int k, int e, int m) {
      this.name = name;
      korean = k;
      english = e;
      math = m;
    }

    @Override
    public int compareTo(Elem other) {
      if(korean != other.korean) return other.korean - korean;
      if(english != other.english) return english - other.english;
      if(math != other.math) return other.math - math;
      return name.compareTo(other.name);
    }
  }

  static StringBuilder sb = new StringBuilder();
  static int N;
  static Elem[] arr;

  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new Elem[N];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      // 국, 영, 수 순서
      arr[i] = new Elem(name, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(arr);

    for(Elem e : arr) {
      sb.append(e.name).append("\n");
    }
    
    System.out.println(sb);
    
    
  
  }
}
