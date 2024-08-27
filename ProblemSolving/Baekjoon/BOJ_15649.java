package baekjoon;

import java.util.Scanner;

public class BOJ_15649 {

	static int n, m;
	static int[] output;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		output = new int[m];
		visit = new boolean[n];

		permutation(0);
	}

	static void permutation(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			output[cnt] = i + 1;
			permutation(cnt + 1);
			visit[i] = false;
		}
	}
}
