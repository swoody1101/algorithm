package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> indexStack = new Stack<Integer>();
		indexStack.push(0);
		for (int i = 1; i < N; i++) {
			while (!indexStack.isEmpty() && input[indexStack.peek()] < input[i]) {
				result[indexStack.pop()] = input[i];
			}
			indexStack.push(i);
		}

		while (!indexStack.isEmpty()) {
			result[indexStack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
