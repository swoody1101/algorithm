package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] examinee = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			examinee[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long result = 0;
		for (int i = 0; i < N; i++) {
			if (examinee[i] <= B) {
				result++;
			} else {
				examinee[i] -= B;
				result++;
				result += examinee[i] / C;
				if (examinee[i] % C != 0) {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}
