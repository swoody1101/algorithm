package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546_평균 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());		
		double sum = 0;
		double maxScore = Double.MIN_VALUE;
		while (st.hasMoreTokens()) {
			double score = Double.parseDouble(st.nextToken());
			sum += score;
			maxScore = Math.max(maxScore, score);
		}
		
		System.out.println(sum * 100 / N / maxScore);
	}
}
