package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] students = new int[6][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken()) - 1;
			students[grade][gender]++;
		}

		int result = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				result += students[i][j] / K;
				if ((students[i][j] % K) != 0)
					result++;
			}
		}
		
		System.out.println(result);
	}
}
