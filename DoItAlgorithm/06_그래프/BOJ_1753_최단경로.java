package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		ArrayList<Edge>[] A = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			A[u].add(new Edge(v, w));
		}

		boolean[] visit = new boolean[V + 1];
		int[] dis = new int[V + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[k] = 0;
		visit[k] = true;

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.offer(new Edge(k, 0));
		while (!queue.isEmpty()) {
			Edge now = queue.poll();
			int nowIdx = now.idx;
			int nowDis = now.dis;
			visit[nowIdx] = true;

			for (Edge next : A[nowIdx]) {
				int nextIdx = next.idx;
				int nextDis = next.dis;
				if (nowDis + nextDis < dis[nextIdx]) {
					dis[nextIdx] = nowDis + nextDis;
					if (!visit[nextIdx]) {
						queue.offer(new Edge(nextIdx, nowDis + nextDis));
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dis[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}

class Edge implements Comparable<Edge> {
	int idx;
	int dis;

	Edge(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}

	@Override
	public int compareTo(Edge o) {
		return this.dis - o.dis;
	}
}
