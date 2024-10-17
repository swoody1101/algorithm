package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] parents = new int[n + 1];
		makeSet(parents);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (order == 0) {
				union(parents, a, b);
			} else {
				if (findSet(parents, a) == findSet(parents, b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	static void makeSet(int[] parents) {
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int[] parents, int num) {
		if (num == parents[num])
			return num;
		return parents[num] = findSet(parents, parents[num]);
	}

	static void union(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);

		if (aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
}
