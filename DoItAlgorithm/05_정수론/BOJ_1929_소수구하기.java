package NumberTheory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (!isPrime[i]) continue;
			for(int j = i * i; j <= N; j += i) {
				isPrime[j] = false;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (isPrime[i])	sb.append(i).append("\n");
		}

		System.out.print(sb.toString());
	}
}
