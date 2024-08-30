package DataStructure;

import java.util.Scanner;

public class BOJ_11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sNum = sc.next();
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			result += (sNum.charAt(i) - '0');
		}
		
		System.out.println(result);
	}
}
