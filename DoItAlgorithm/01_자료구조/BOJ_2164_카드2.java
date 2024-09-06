package DataStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		while (deque.size() != 1) {
			deque.pollFirst();
			deque.addLast(deque.pollFirst());
			

		}
		System.out.println(deque.poll());
	}
}
