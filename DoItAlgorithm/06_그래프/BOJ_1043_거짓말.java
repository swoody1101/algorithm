package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] people = new int[N + 1];
		makeSet(people);

		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		for (int i = 0; i < know; i++) {
			people[Integer.parseInt(st.nextToken())] = 0;
		}

		ArrayList<Integer>[] party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			party[i].add(first);
			for (int j = 1; j < cnt; j++) {
				int now = Integer.parseInt(st.nextToken());
				party[i].add(now);
				union(people, first, now);
			}
		}

		int result = 0;
		for (int i = 0; i < M; i++) {
			boolean participation = true;
			for (int idx : party[i]) {
				if (findSet(people, idx) == 0) {
					participation = false;
					break;
				}
			}
			if (participation) result++;
		}

		System.out.println(result);
	}

	static void makeSet(int[] set) {
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
	}
	
	static int findSet(int[] set, int num) {
		if (num == set[num]) return num;
		return set[num] = findSet(set, set[num]);
	}
	
	static void union(int[] set, int a, int b) {
		int aRoot = findSet(set, a);
		int bRoot = findSet(set, b);
		
		if (aRoot > bRoot) set[aRoot] = bRoot;
		else set[bRoot] = aRoot;
	}
}
