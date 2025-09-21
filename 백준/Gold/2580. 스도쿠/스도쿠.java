import java.util.*;
import java.io.*;

public class Main{

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[][] A;
  static int[][] empty;

  static boolean valid_check(int row, int column) {
    
    boolean[] check;
    // 가로 체크
    check = new boolean[10];
    for(int j = 1; j <= 9; j++) {
      if(A[row][j] == 0) continue;
      if(check[A[row][j]]) {
        return false;
      }
      check[A[row][j]] = true;
    }
    
    // 세로 체크
    check = new boolean[10];
    for(int i = 1; i <= 9; i++) {
      if(A[i][column] == 0) continue;
      if(check[A[i][column]]) {
        return false;
      }
      check[A[i][column]] = true;
    }
    
    // 3x3 상자 체크
    int standard_row = (row - 1) / 3 * 3 + 1;
    int standard_column = (column- 1) / 3 * 3 + 1;
    check = new boolean[10];
    for(int i = standard_row; i <= standard_row+2; i++) { // 1 4 7
      for(int j = standard_column; j <= standard_column+2; j++) {
        if(A[i][j] == 0) continue;
        if(check[A[i][j]]) {
          return false;
        }
        check[A[i][j]] = true;
      }
    }

    return true;
  }

  static void rec_func(int k) {    
    if(empty[k][0] == 0) {
      if(sb.length() != 0) return;
      for(int i = 1; i <= 9; i++) {
        for(int j = 1; j <= 9; j++) {
          sb.append(A[i][j]).append(" ");
        }
        sb.append("\n");
      }
      System.out.println(sb);
    } else {
      for(int cand = 1; cand <= 9; cand++) {
        A[empty[k][0]][empty[k][1]] = cand;
        if(valid_check(empty[k][0], empty[k][1])) rec_func(k+1);
        A[empty[k][0]][empty[k][1]] = 0;
      }
    }
  }
  
  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());

    A = new int[10][10];
    empty = new int[82][2];

    for(int i = 1; i <= 9; i++) {
      String[] s = br.readLine().split(" ");
      for(int j = 0; j < 9; j++) {
        A[i][j+1] = Integer.parseInt(s[j]);
      }
    }

    // 빈 위치 찾기
    int k = 1;
    for(int i = 1; i <= 9; i++) {
      for(int j = 1; j <= 9; j++) {
        if(A[i][j] == 0) {
          empty[k][0] = i;
          empty[k][1] = j;
          k++;
        }
      }
    }
    
    rec_func(1);
    
  }
}
