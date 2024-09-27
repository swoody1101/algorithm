package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pQueue.offer(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		int result = 0;
		while (pQueue.size() !=  1) {
			sum = pQueue.poll() + pQueue.poll();
			result += sum;
			pQueue.offer(sum);
		}

		System.out.println(result);
	}
}
