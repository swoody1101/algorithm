package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

	static ArrayList<Integer>[] input;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		input = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			input[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			input[u].add(v);
			input[v].add(u);
		}

		visit = new boolean[N + 1];
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				result++;
				dfs(i);
			}
		}

		System.out.println(result);
	}

	static void dfs(int i) {
		if (visit[i]) {
			return;
		}

		visit[i] = true;
		for (int next : input[i]) {
			if (visit[next])
				continue;
			dfs(next);
		}
	}
}