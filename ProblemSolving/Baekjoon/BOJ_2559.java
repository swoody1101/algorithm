package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		for (int i = 0; i < K; i++) {
			result += temp[i];
		}
		int sum = result;
		for (int i = K; i < N; i++) {
			sum = sum + temp[i] - temp[i - K];
			if (result < sum)
				result = sum;
		}

		System.out.println(result);
	}
}
