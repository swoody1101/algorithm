package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
		}

		int[] result = new int[N + 1];
		boolean[] visit;
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			bfs(graph, result, visit, i);
		}
		
		int maxCnt = 0;
		for (int i = 1; i <= N; i++) {
			maxCnt = Math.max(maxCnt, result[i]); 
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (result[i] == maxCnt) sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}

	static void bfs(ArrayList<Integer>[] graph, int[] result, boolean[] visit, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visit[start] = true;
		result[start]++;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : graph[now]) {
				if (visit[next]) continue;
				visit[next] = true;
				result[next]++;
				queue.offer(next);
			}
		}
	}
}
