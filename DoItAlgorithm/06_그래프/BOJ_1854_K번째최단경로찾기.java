package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1854_K번째최단경로찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Node_1854>[] A = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Node_1854>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[a].add(new Node_1854(b, c));
		}

		PriorityQueue<Integer>[] dis = new PriorityQueue[n + 1];
		for (int i = 1; i <= n; i++) {
			dis[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}
		PriorityQueue<Node_1854> pQueue = new PriorityQueue<Node_1854>();
		pQueue.offer(new Node_1854(1, 0));
		dis[1].add(0);

		while (!pQueue.isEmpty()) {
			Node_1854 now = pQueue.poll();
			int nowIdx = now.idx;
			int nowDis = now.dis;

			for (Node_1854 next : A[nowIdx]) {
				int nextIdx = next.idx;
				int nextDis = next.dis + nowDis;

				if (dis[nextIdx].size() >= k) {
					if (dis[nextIdx].peek() > nextDis) {
						dis[nextIdx].poll();
						dis[nextIdx].offer(nextDis);
						pQueue.offer(new Node_1854(nextIdx, nextDis));
					}
				} else {
					dis[nextIdx].offer(nextDis);
					pQueue.offer(new Node_1854(nextIdx, nextDis));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (dis[i].size() < k)
				sb.append("-1\n");
			else
				sb.append(dis[i].peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}

class Node_1854 implements Comparable<Node_1854> {
	int idx;
	int dis;

	Node_1854(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node_1854 o) {
		return this.dis - o.dis;
	}
}
