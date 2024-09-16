package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_K번째수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(input, 0, N - 1, K - 1);
		System.out.println(input[K - 1]);
	}

	static void quickSort(int[] input, int start, int end, int k) {
		if (start < end) {
			int pivot = partition(input, start, end);

			if (pivot == k) {
				return;
			} else if (pivot < k) {
				quickSort(input, pivot + 1, end, k);
			} else if (pivot > k) {
				quickSort(input, start, pivot - 1, k);
			}
		}
	}

	static int partition(int[] input, int start, int end) {
		if (start + 1 == end) {
			if (input[start] > input[end]) {
				swap(input, start, end);
			}
			return end;
		}
		
		int m = (start + end) / 2;
		swap(input, start, m);
		int pivot = input[start];
		int s = start + 1;
		int e = end;
		while (s <= e) {
			while (input[s] < pivot && s < input.length - 1) {
				s++;
			}
			while (input[e] > pivot && e > 0) {
				e--;
			}
			if (s <= e) {
				swap(input, s++, e--);
			}
		}
		swap(input, start, e);
		return e;
	}

	static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
