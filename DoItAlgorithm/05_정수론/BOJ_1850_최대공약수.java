package NumberTheory;

import java.util.Scanner;

public class BOJ_1850_최대공약수 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long result = getGCD(A, B);

		StringBuilder sb = new StringBuilder();
		for (long i = 0; i < result; i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());
	}

	static long getGCD(long a, long b) {
		while (a % b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}
