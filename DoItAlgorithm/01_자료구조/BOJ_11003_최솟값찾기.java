package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11003_최솟값찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> deque = new LinkedList<Node>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!deque.isEmpty() && deque.peekLast().value > num) {
				deque.pollLast();
			}
			deque.addLast(new Node(i, num));

			int start = i - L + 1;
			while (deque.peekFirst().index < start) {
				deque.pollFirst();
			}

			sb.append(deque.peekFirst().value).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

class Node {
	int index;
	int value;

	public Node(int index, int value) {
		this.index = index;
		this.value = value;
	}
}
