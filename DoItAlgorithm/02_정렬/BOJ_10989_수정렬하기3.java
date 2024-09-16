package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if (max < input[i]) {
				max = input[i];
			}
		}

		int maxSize = 1;
		while (max >= 10) {
			max /= 10;
			maxSize++;
		}

		radixSort(input, maxSize);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(input[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void radixSort(int[] A, int maxSize) {
		int[] output = new int[A.length];
		int exp = 1;
		int count = 0;
		while (count != maxSize) {
			int[] bucket = new int[10];
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / exp) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) {
				output[bucket[(A[i] / exp % 10)] - 1] = A[i];
				bucket[(A[i] / exp) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {
				A[i] = output[i];
			}
			exp = exp * 10;
			count++;
		}
	}
}
