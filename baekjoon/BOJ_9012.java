package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	static int T;
	static String s;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			s = br.readLine();
			stack = new Stack<>();
			sb.append(check()).append("\n");
		}

		System.out.println(sb);
	}

	static String check() {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (stack.isEmpty()) {
				return "NO";
			} else {
				stack.pop();
			}
		}
		if (stack.isEmpty()) return "YES";
		else return "NO";
	}
}
