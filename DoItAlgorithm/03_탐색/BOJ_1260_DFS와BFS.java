package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static ArrayList<Integer>[] input;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		input = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input[a].add(b);
			input[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(input[i]);
		}

		visit = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visit = new boolean[N + 1];
		bfs(V);
		System.out.println();
	}

	static void dfs(int start) {
		System.out.print(start + " ");
		visit[start] = true;
		
		for (int i : input[start]) {
			if (!visit[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visit[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int i : input[now]) {
				if (!visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
}
