package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());

		List<Node>[] tree = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<Node>();
		}

		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1) {
					break;
				}
				int dis = Integer.parseInt(st.nextToken());
				tree[from].add(new Node(to, dis));
			}
		}

		int[] distance = new int[V + 1];
		bfs(tree, distance, 1);
		int maxIdx = 1;
		for (int i = 2; i <= V; i++) {
			if (distance[maxIdx] < distance[i]) maxIdx = i;
		}
		distance = new int[V + 1];
		bfs(tree, distance, maxIdx);
		
		Arrays.sort(distance);
		System.out.println(distance[V]);
	}

	static void bfs(List<Node>[] tree, int[] distance, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visit = new boolean[tree.length];
		queue.offer(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (Node next : tree[now]) {
				int nextIdx = next.to;
				int nextDis = distance[now] + next.dis;
				if (visit[nextIdx]) continue;
				visit[nextIdx] = true;
				queue.offer(nextIdx);
				distance[nextIdx] = nextDis;
			}
		}
	}
}

class Node {
	int to;
	int dis;

	Node(int to, int dis) {
		this.to = to;
		this.dis = dis;
	}
}