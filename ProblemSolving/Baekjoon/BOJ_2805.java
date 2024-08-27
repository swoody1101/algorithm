package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];

		long max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(trees[i], max);
		}

		max++;
		long min = 0;
		long mid, sum;
		while (min < max) {
			mid = (min + max) / 2;
			sum = 0;
			for (int i = 0; i < N; i++) {
				long temp = trees[i] - mid;
				if (temp > 0)
					sum += temp;
			}
			if (sum < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}
}
