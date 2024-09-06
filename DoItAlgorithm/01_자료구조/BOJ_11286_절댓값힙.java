package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Number> pqueue = new PriorityQueue<Number>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pqueue.add(new Number(x));
			} else {
				if (pqueue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pqueue.poll().number).append("\n");
				}
			}
		}

		System.out.println(sb.toString());
	}
}

class Number implements Comparable<Number> {
	int number;

	Number(int number) {
		this.number = number;
	}

	@Override
	public int compareTo(Number o) {
		if (Math.abs(this.number) == Math.abs(o.number)) {
			return this.number > o.number ? 1 : -1;
		} else {
			return Math.abs(this.number) - Math.abs(o.number);
		}
	}
}
