package Search;

import java.util.Scanner;

public class BOJ_2023_신기한소수 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}

	static void dfs(int num, int exp) {
		if (exp == N) {
			if (isPrime(num)) {
				System.out.println(num);
			}
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 0) {
				continue;
			}
			int nextNum = (num * 10) + i;
			if (isPrime(nextNum)) {
				dfs(nextNum, exp + 1);
			}
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
