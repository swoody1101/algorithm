package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();

		int num = 1;
		for (int i = 0; i < n; i++) {
			int target = sc.nextInt();

			while (num <= target && num <= n) {
				stack.push(num++);
				sb.append("+\n");
			}

			if (!stack.isEmpty()) {
				if (target == stack.peek()) {
					stack.pop();
					sb.append("-\n");
				} else if (target < stack.peek()) {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println(sb.toString());
	}
}
