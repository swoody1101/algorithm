package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] rootCity = new int[N + 1];
		makeSet(rootCity);

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(rootCity, i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());
			if (findSet(rootCity, start) != findSet(rootCity, next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	static void makeSet(int[] rootCity) {
		for (int i = 0; i < rootCity.length; i++) {
			rootCity[i] = i;
		}
	}

	static int findSet(int[] rootCity, int num) {
		if (num == rootCity[num]) return num;
		return rootCity[num] = findSet(rootCity, rootCity[num]);
	}

	static void union(int[] rootCity, int a, int b) {
		int aRoot = findSet(rootCity, a);
		int bRoot = findSet(rootCity, b);

		if (aRoot > bRoot) rootCity[aRoot] = bRoot;
		else rootCity[bRoot] = aRoot;
	}
}
