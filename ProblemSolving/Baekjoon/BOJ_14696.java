package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A, B;

		for (int i = 0; i < N; i++) {
			A = new int[4];
			B = new int[4];
			setCards(A, br.readLine());
			setCards(B, br.readLine());

			for (int j = 3; j >= 0; j--) {
				if (A[j] > B[j]) {
					sb.append('A').append("\n");
					break;
				} else if (A[j] < B[j]) {
					sb.append('B').append("\n");
					break;
				} else if (j == 0) {
					sb.append('D').append("\n");
				}
			}
		}

		System.out.println(sb);
	}

	static int[] setCards(int[] set, String s) {
		StringTokenizer st = new StringTokenizer(s);
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int card = Integer.parseInt(st.nextToken());
			set[card - 1]++;
		}
		return set;
	}
}
