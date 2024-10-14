package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] graph = new ArrayList[V + 1];
			for (int j = 1; j <= V; j++) {
				graph[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}

			int[] visit = new int[V + 1];
			boolean result = true;
			for (int j = 1; j <= V; j++) {
				if (visit[j] == 0) {
					result = bfs(graph, visit, j);
					if (!result) break;
				}
			}
			if (result) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	static boolean bfs(ArrayList<Integer>[] graph, int[] visit, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visit[start] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			int flag = (visit[now] * -1);
			for (int next : graph[now]) {
				if (visit[next] == visit[now]) {
					return false;
				} else if (visit[next] == 0) {
					visit[next] = flag;
					queue.offer(next);
				}
			}
		}
		return true;
	}
}
