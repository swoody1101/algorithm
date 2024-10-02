package NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1747_소수n팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] isPrime = new boolean[10000000];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}

		sc.close();
		for (int i = N; i < isPrime.length; i++) {
			if (isPrime[i] && isPalindrome(i)) {
				System.out.println(i);
				return;
			}
		}
	}

	static boolean isPalindrome(int num) {
		String s = Integer.toString(num);

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
}
