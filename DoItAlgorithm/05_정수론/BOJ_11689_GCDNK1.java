package NumberTheory;

import java.util.Scanner;

public class BOJ_11689_GCDNK1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long result = n;

		for (long p = 2; p <= Math.sqrt(n); p++) {
			if (n % p == 0) {
				result -= (result / p);
				while (n % p == 0) {
					n /= p;
				}
			}
		}
		if (n > 1) {
			result -= (result / n);
		}
		
		System.out.println(result);
	}
}
