package NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1456_거의소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		boolean[] isPrime = new boolean[10000001];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if (!isPrime[i]) continue;
			for (int j = i * i; j <= 10000000; j += i) {
				isPrime[j] = false;
			}
		}

		int cnt = 0;
		for (int i = 2; i <= Math.sqrt(B); i++) {
			if (isPrime[i]) {
				long power = (long) i * i;
				while (power <= B) {
					if (power >= A) cnt++;
					if (power > B / i) break;
					power *= i;
				}
			}
		}

		System.out.println(cnt);
		sc.close();
	}
}