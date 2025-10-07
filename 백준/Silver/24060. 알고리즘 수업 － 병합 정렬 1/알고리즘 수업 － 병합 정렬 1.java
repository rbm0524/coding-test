import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, K, cnt;
  static int ans = -1;
  static int[] A, tmp;

  static void merge_sort(int p, int r) {
    if(p < r) {
      int mid = (p+r)/2;
      merge_sort(p, mid);
      merge_sort(mid+1, r);
      merge(p, mid, r);
    }
  }

  static void merge(int p, int mid, int r) {
    int i = p;
    int j = mid+1;
    int t = 1;
    while(i <= mid && j <= r) {
      if(A[i] <= A[j]) {
        tmp[t++] = A[i++];
      } else {
        tmp[t++] = A[j++];
      }
    }
    while(i <= mid) {
      tmp[t++] = A[i++];
    }

    while(j <= r) {
      tmp[t++] = A[j++];
    }

    i = p;
    t = 1;
    while(i <= r) {
      A[i] = tmp[t];
      cnt++;
      if(cnt == K) {
        ans = A[i];
      }
      i++;
      t++;
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    A = new int[N+1];
    tmp = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    merge_sort(1, N);

    System.out.println(ans);
  }
}
