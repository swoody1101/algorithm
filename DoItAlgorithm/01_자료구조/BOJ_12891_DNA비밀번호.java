package DataStructure;

import java.util.Scanner;

public class BOJ_12891_DNA비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();
		String dna = sc.next();

		// 0 : A, 1 : C, 2 : G, 3 : T
		int[] checklist = new int[4];
		for (int i = 0; i < 4; i++) {
			checklist[i] = sc.nextInt();
		}

		// 0 : A, 1 : C, 2 : G, 3 : T
		int[] window = new int[4];
		final int ADD = 1;
		final int SUB = -1;
		int start = 0;
		int end = 0;
		int answer = 0;

		while (end < P) {
			window = createWindow(window, dna.charAt(end++), ADD);
		}
		end = P - 1;
		
		while (end < S) {
			boolean check = true;
			for (int j = 0; j < 4; j++) {
				if (window[j] < checklist[j]) {
					check = false;
					break;
				}
			}
			if (check) answer++;
			if (end + 1 == S) break;
			window = createWindow(window, dna.charAt(start++), SUB);
			window = createWindow(window, dna.charAt(++end), ADD);
		}

		System.out.println(answer);
	}

	private static int[] createWindow(int[] window, char c, int mode) {
		if (c == 'A') {
			window[0] += mode;
		} else if (c == 'C') {
			window[1] += mode;
		} else if (c == 'G') {
			window[2] += mode;
		} else {
			window[3] += mode;
		}

		return window;
	}
}
