package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_특정거리의도시찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
		}

		boolean[] visit = new boolean[N + 1];
		int[] minDis = new int[N + 1];		
		bfs(graph, visit, minDis, x);
		
		StringBuilder sb = new StringBuilder();
		for (int i =0; i < minDis.length; i++) {
			if (minDis[i] == K) sb.append(i).append("\n");
		}
		if (sb.length() == 0) sb.append(-1);
		
		System.out.println(sb);
	}

	static void bfs(ArrayList<Integer>[] graph, boolean[] visit, int[] minDis, int start) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start, 0));
		visit[start] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int nextDis = now.dis + 1;
			for (int next : graph[now.idx]) {
				if (visit[next]) continue;
				minDis[next] = nextDis;
				visit[next] = true;
				queue.add(new Node(next, nextDis));
			}
		}
	}
}

class Node {
	int idx;
	int dis;

	Node(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}
}
