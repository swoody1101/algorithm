package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9093 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuffer result = new StringBuffer();
		StringBuffer sb;
		String[] s;
		for (int t = 0; t < T; t++) {
			s = br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) {
				sb = new StringBuffer(s[i]);
				result.append(sb.reverse().toString()).append(" ");
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}
}
