package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
	
	static int n;
	static int input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();		
		n = Integer.parseInt(br.readLine());

		int start = 0;
		while(n-- > 0) {
			input = Integer.parseInt(br.readLine());
			if(input > start) {
				for(int i = start + 1; i <= input; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = input;
			} else if(input != stack.peek()) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");			
		}
		
		System.out.print(sb);
	}
}