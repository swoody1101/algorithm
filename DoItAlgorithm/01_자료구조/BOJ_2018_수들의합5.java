package DataStructure;

import java.util.Scanner;

public class BOJ_2018_수들의합5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 1;
		int end = 1;
		int sum = 1;
		int answer = 0;
		
		while (start <= N) {
			if (sum == N) {
				answer++;
				sum -= start++;
			} else if (sum > N) {
				sum -= start++;
			} else if (sum < N) {
				sum += ++end;
			}
		}
		
		System.out.println(answer);
	}
}
