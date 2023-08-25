package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096 {

	static int[][] window = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] cur = new int[3];
		int[] min = new int[3];
		int[] max = new int[3];
		int[] minTemp = new int[3];
		int[] maxTemp = new int[3];

		st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 3; j++) {
			min[j] = Integer.parseInt(st.nextToken());
		}
		max = min.clone();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cur[j] = Integer.parseInt(st.nextToken());
			}
			minTemp = min.clone();
			maxTemp = max.clone();

			max[0] = cur[0] + Math.max(maxTemp[0], maxTemp[1]);
			max[1] = cur[1] + Math.max(maxTemp[0], Math.max(maxTemp[1], maxTemp[2]));
			max[2] = cur[2] + Math.max(maxTemp[1], maxTemp[2]);

			min[0] = cur[0] + Math.min(minTemp[0], minTemp[1]);
			min[1] = cur[1] + Math.min(minTemp[0], Math.min(minTemp[1], minTemp[2]));
			min[2] = cur[2] + Math.min(minTemp[1], minTemp[2]);
		}

		Arrays.sort(min);
		Arrays.sort(max);

		System.out.println(max[2] + " " + min[0]);
	}
}
