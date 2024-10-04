package NumberTheory;

import java.util.Scanner;

public class BOJ_1016_제곱ㄴㄴ수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		sc.close();
		boolean[] isPower = new boolean[(int) (max - min + 1)];
		
		for (int i = 2; i <= Math.sqrt(max); i++) {
			long pow = (long)i * i;
			long start = min / pow;
			if (min % pow != 0)	start++;
			for (long j = start; pow * j <= max; j++) {
				isPower[(int) ((j * pow) - min)] = true;
			}
		}

		int result = 0;
		for (int i = 0; i < isPower.length; i++) {
			if (!isPower[i])
				result++;
		}

		System.out.println(result);
	}
}
