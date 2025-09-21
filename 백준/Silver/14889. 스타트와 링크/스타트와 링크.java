  import java.util.*;
  import java.io.*;
  
  public class Main{
  
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] start_team, link_team;
    static boolean[] used;
    static int min = Integer.MAX_VALUE;
    static int[][] A;
  
    static void rec_func(int k, int start) {
      if(k == N/2 + 1) {
        int start_sum = 0;
        int link_sum = 0;
  
        //link_team 구성하기
        int u = 1;
        for(int j = 1; j <= N; j++) {
          if(!used[j]) {
            link_team[u++] = j;
          }
        }
  
        //각 합 계산하기
        for(int i = 1; i <= N/2; i++) {
          for(int j = i+1; j <= N/2; j++) {
            start_sum += A[start_team[i]][start_team[j]];
            start_sum += A[start_team[j]][start_team[i]];
          }
        }
  
        for(int i = 1; i <= N/2; i++) {
          for(int j = i+1; j <= N/2; j++) {
            link_sum += A[link_team[i]][link_team[j]];
            link_sum += A[link_team[j]][link_team[i]];
          }
        }
  
        int gap = Math.abs(start_sum - link_sum);
        if(gap < min) {
          min = gap;
        }
        
      } else { // 팀 나누기
        for(int cand = start; cand <= N; cand++) {          
          start_team[k] = cand;
          used[cand] = true;
          rec_func(k+1, cand + 1);
          start_team[k] = 0;
          used[cand] = false;  
        }
      }
      
    }
    
    public static void main(String args[]) throws IOException {
  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
  
      N = Integer.parseInt(st.nextToken());
      A = new int[N+1][N+1];
      start_team = new int[N/2+1];
      link_team = new int[N/2+1];
      used = new boolean[N+1];
  
      
      for(int i = 1; i <= N; i++) {
        String[] s = br.readLine().split(" ");
        for(int j = 1; j <= N; j++) {
          A[i][j] = Integer.parseInt(s[j-1]);
        }
      }
  
      rec_func(1, 1);
  
      System.out.println(min);
      
    }
  }
