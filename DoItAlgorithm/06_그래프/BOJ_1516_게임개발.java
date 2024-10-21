package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] building = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			building[i] = new ArrayList<Integer>();
		}
		int[] time = new int[N + 1];
		int[] indegree = new int[N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int prev = Integer.parseInt(st.nextToken());
				if (prev != -1) {
					building[prev].add(i);
					indegree[i]++;
				}
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		int[] result = new int[N + 1];
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : building[now]) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[now] + time[now]);
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder(); 
		for (int i = 1; i <= N; i++) {
			result[i] += time[i];
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
