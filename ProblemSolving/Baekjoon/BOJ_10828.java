package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10828 {

	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		n = Integer.parseInt(br.readLine());

		int num = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			if (s.contains("push")) {
				num = Integer.parseInt(s.substring(5));
				stack.push(num);
				continue;
			} else if (s.equals("pop")) {
				if (stack.isEmpty()) num = -1;
				else num = stack.pop();
			} else if (s.equals("size")) {
				num = stack.size();
			} else if (s.equals("empty")) {
				if (stack.isEmpty()) num = 1;
				else num = 0;
			} else if (s.equals("top")) {
				if (stack.isEmpty()) num = -1;
				else num = stack.peek();
			}
			System.out.println(num);
		}
	}
}
