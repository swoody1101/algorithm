package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];

		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (start < A[i]) start = A[i];
			end += A[i];
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 0;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (mid < sum + A[i]) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if (sum != 0) count++;
			
			if (count > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(start);
	}
}
