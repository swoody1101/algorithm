package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

	static int n, m;
	static int[] input, output;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		output = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);

		permutation(0);
		System.out.println(sb);
	}

	static void permutation(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			output[depth] = input[i];
			permutation(depth + 1);
			visit[i] = false;
		}
	}
}
