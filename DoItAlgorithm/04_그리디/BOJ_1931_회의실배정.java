package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Meeting> mQueue = new PriorityQueue<Meeting>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			mQueue.offer(new Meeting(start, end));
		}

		int cnt = 0;
		Meeting prev = null;
		while (!mQueue.isEmpty()) {
			Meeting now = mQueue.poll();
			if (prev == null || now.start >= prev.end) {
				cnt++;
				prev = now;
			}
		}

		System.out.println(cnt);
	}
}

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
}
