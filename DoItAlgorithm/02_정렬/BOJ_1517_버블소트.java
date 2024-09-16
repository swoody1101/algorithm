package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1517_버블소트 {

	static long result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] temp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(A, temp, 0, N - 1);
		System.out.println(result);
	}

	static void mergeSort(int[] A, int[] temp, int s, int e) {
		if (e - s < 1) {
			return;
		}

		int m = (s + e) / 2;
		mergeSort(A, temp, s, m);
		mergeSort(A, temp, m + 1, e);

		for (int i = s; i <= e; i++) {
			temp[i] = A[i];
		}

		int k = s;
		int p1 = s;
		int p2 = m + 1;
		while (p1 <= m && p2 <= e) {
			if (temp[p1] > temp[p2]) {
				result += (p2 - k);
				A[k++] = temp[p2++];
			} else {
				A[k++] = temp[p1++];
			}
		}
		while (p1 <= m) {
			A[k++] = temp[p1++];
		}
		while (p2 <= e) {
			A[k++] = temp[p2++];
		}
	}
}
