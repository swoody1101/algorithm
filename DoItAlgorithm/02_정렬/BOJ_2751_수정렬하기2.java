package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2751_수정렬하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		int[] temp = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(input, temp, 0, N - 1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(input[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	static void mergeSort(int[] input, int[] temp, int s, int e) {
		if (e - s < 1) {
			return;
		}
		
		int m = (s + e) / 2;
		mergeSort(input, temp, s, m);
		mergeSort(input, temp, m + 1, e);
		
		for (int i = s; i <= e; i++) {
			temp[i] = input[i]; 
		}
		
		int k = s;
		int p1 = s;
		int p2 = m + 1;
		while(p1 <= m && p2 <= e) {
			if(temp[p1] < temp[p2]) {
				input[k++] = temp[p1++];
			} else {
				input[k++] = temp[p2++];
			}
		}
		while(p1 <= m) {
			input[k++] = temp[p1++];
		}
		while(p2 <= e) {
			input[k++] = temp[p2++];
		}
	}

	static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
