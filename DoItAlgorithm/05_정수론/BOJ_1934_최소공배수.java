package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int gcd = 1;
			if (A == B) {
				gcd = A;
			} else if (A > B) {
				gcd = getGCD(A, B);
			} else {
				gcd = getGCD(B, A);
			}
			sb.append(A * B / gcd).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int getGCD(int a, int b) {
		int r = b;
		while (a % b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
}
