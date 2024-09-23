package Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());

			int start = 0;
			int end = N - 1;
			int mid;
			boolean exist = false;
			while (start <= end) {
				mid = (start + end) / 2;
				if (target == A[mid]) {
					bw.append("1\n");
					exist = true;
					break;
				} else if (target > A[mid]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			if (!exist) {
				bw.append("0\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
