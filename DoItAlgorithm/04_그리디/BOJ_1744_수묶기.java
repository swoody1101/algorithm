package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1744_수묶기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> mQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num <= 0) {
				mQueue.offer(num);
			} else {
				pQueue.offer(num);
			}
		}

		int result = 0;
		while (mQueue.size() > 1) {
			result += (mQueue.poll() * mQueue.poll());
		}
		if (!mQueue.isEmpty()) result += mQueue.poll();
		
		while (pQueue.size() > 1) {
			int num1 = pQueue.poll();
			int num2 = pQueue.poll();
			if (num1 == 1 || num2 == 1) {
				result += (num1 + num2);
			} else {
				result += (num1 * num2);
			}
		}
		if (!pQueue.isEmpty()) result += pQueue.poll();

		System.out.println(result);
	}
}
