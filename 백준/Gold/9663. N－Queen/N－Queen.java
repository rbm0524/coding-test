import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N, ans;
  static int[] col; // 1~N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
  // i번의 퀸은 col[i]번 열에 놓았다는 기록

  static boolean validaity_check() {
    for(int i = 1; i<= N; i++) {
      //i번째 행보다 높이 있는 퀸들 중에서 자신을 공격할 수 있는 퀸을 본다.
      for(int j = 1; j < i; j++) {
        if(attackable(i, col[i], j, col[j])) {
          return false;
        }
      }
    }
    
    return true;
  }

  static boolean attackable(int r1, int c1, int r2, int c2) {
    if(c1 == c2) return true; // 같은 열
    if(r1 - c1 == r2 - c2) return true; // 대각선 관계
    if(r1 + c1 == r2 + c2) return true; // 대각선 관계
    return false; // 아무 관계 아닐 때
  }

  static void rec_func(int row) {
    if(row == N+1) { // 1~N까지 '성공적으로' 놓았을 때만 ans를 추가하도록 하자
      ans++;
    } else {
      for(int i = 1; i <= N; i++) { // N*N이니까 열도 N개
        boolean possible = true;
        //놓을 수 있는지 검사
        // 이전에 놓였던 것들을 통해 현재 위치에 놓을 수 있는지 검사
        for(int j = 1; j <= row-1; j++) {
          if(attackable(j, col[j], row, i)) { // 이전에 놓았던 것들 vs 현재 놓을 것
            possible = false;
            break;
          }
        }
        if(!possible) continue;
        col[row] = i;
        rec_func(row+1);
        col[row] = 0;
      }
    }
  }
 
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    ans = 0;
    col = new int[N+1];

    rec_func(1);

    System.out.println(ans);
    
    
  }
}
