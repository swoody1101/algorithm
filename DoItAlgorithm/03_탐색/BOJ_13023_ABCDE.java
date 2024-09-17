package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] friends = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}

		boolean[] visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			dfs(friends, visit, i, 0);
			if(result == 1) break;
		}

		System.out.println(result);
	}

	static void dfs(ArrayList<Integer>[] friends, boolean[] visit, int now, int depth) {
		if (result == 1 || depth == 4) {
			result = 1;
			return;
		}

		visit[now] = true;
		for (int next : friends[now]) {
			if (!visit[next]) {
				dfs(friends, visit, next, depth + 1);
			}
		}
		visit[now] = false;
	}
}
