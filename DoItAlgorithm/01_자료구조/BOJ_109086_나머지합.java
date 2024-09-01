package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_109086_나머지합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long sum = 0;
		long prevSum = 0;
		long remainderZero = 0;
		long[] remainders = new long[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			sum = prevSum + Long.parseLong(st.nextToken());
			prevSum = sum;
			if (sum % M == 0) {
				remainderZero++;
			} else {
				remainders[(int) (sum % M)]++;
			}
		}
		
		long answer = (remainderZero * (remainderZero + 1) / 2);
		for (int i = 0; i < M; i++) {
			answer += (remainders[i] * (remainders[i] - 1) / 2);
		}

		System.out.println(answer);
	}
}
