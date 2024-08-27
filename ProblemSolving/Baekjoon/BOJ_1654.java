package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] line = new int[K];

		long max = 0;
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			if (line[i] > max)
				max = line[i];
		}

		max++;
		long min = 0;
		long mid, cnt;
		while (min < max) {
			mid = (max + min) / 2;
			cnt = 0;

			for (int i = 0; i < K; i++) {
				cnt += (line[i] / mid);
			}
			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}
