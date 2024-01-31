package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stackL = new Stack<>();
		Stack<Character> stackR = new Stack<>();

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			stackL.push(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken().charAt(0)) {
			case 'L':
				if (!stackL.isEmpty())
					stackR.push(stackL.pop());
				break;
			case 'D':
				if (!stackR.isEmpty())
					stackL.push(stackR.pop());
				break;
			case 'B':
				if (!stackL.isEmpty())
					stackL.pop();
				break;
			case 'P':
				stackL.push(st.nextToken().charAt(0));
				break;
			}
		}

		for (int i = 0; i < stackL.size(); i++) {
			sb.append(stackL.get(i));
		}
		while (!stackR.isEmpty()) {
			sb.append(stackR.pop());
		}
		System.out.println(sb.toString());

	}
}