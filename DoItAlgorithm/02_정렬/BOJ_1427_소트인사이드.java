package Sort;

import java.util.Scanner;

public class BOJ_1427_소트인사이드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int n = s.length();
		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = s.charAt(i) - '0';
		}

		for (int i = 0; i < n; i++) {
			int max = i;
			for (int j = i + 1; j < n; j++) {
				if (input[max] < input[j]) {
					max = j;
				}
			}
			if (i != max) {
				int temp = input[i];
				input[i] = input[max];
				input[max] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(input[i]);
		}
	}
}
