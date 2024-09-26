package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (K == 0) break;
			if (A[i] <= K) {
				sum += (K / A[i]);
				K %= A[i];
			}
		}
		
		System.out.println(sum);
	}
}
