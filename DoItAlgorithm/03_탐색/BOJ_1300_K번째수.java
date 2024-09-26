package Search;

import java.util.Scanner;

public class BOJ_1300_K번째수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		long start = 1;
		long end = k;
		while (start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			boolean over = false;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
				if (cnt >= k) {
					over = true;
					break;
				}
			}

			if (over) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(start);
	}
}
