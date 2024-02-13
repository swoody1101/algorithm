package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CDT_바이러스검사 {

	static int n;
	static int[] res;
	static int reader, member;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		res = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			res[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		reader = Integer.parseInt(st.nextToken());
		member = Integer.parseInt(st.nextToken());

		long result = 0;
		result += n;
		for (int i = 0; i < n; i++) {
			res[i] -= reader;
			if (res[i] > 0) {
				result += res[i] / member;
				if (res[i] % member != 0) result++;
			}
		}
		
		System.out.println(result);
	}
}
