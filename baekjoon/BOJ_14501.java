package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int day = Integer.parseInt(br.readLine());
		int[] run_day = new int[20];
		int[] pay = new int[20];
		int[] dp = new int[20];

		for (int i = 1; i <= day; i++) {
			String[] input = br.readLine().split(" ");
			run_day[i] = Integer.parseInt(input[0]);
			pay[i] = Integer.parseInt(input[1]);
		}

		for (int i = day; i > 0; i--) {
			if (run_day[i] > day - i + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(pay[i] + dp[i + run_day[i]], dp[i + 1]);
			}
		}

		System.out.print(dp[1]);
	}
}
