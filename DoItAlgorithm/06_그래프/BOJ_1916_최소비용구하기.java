package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		ArrayList<City_1916>[] A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<City_1916>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			A[from].add(new City_1916(to, dis));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		boolean[] visit = new boolean[N + 1];
		int[] dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		PriorityQueue<City_1916> queue = new PriorityQueue<City_1916>();
		queue.offer(new City_1916(start, 0));
		
		while (!queue.isEmpty()) {
			City_1916 now = queue.poll();
			int nowIdx = now.idx;
			int nowDis = now.dis;
			visit[nowIdx] = true;
			if (visit[end]) break;
				
			for (City_1916 next : A[nowIdx]) {
				int nextIdx = next.idx;
				int nextDis = next.dis;
				if (dis[nextIdx] > nowDis + nextDis) {
					dis[nextIdx] = nowDis + nextDis;
					if (!visit[nextIdx]) {
						queue.offer(new City_1916(nextIdx, nowDis + nextDis));
					}
				}
			}
		}
		
		System.out.println(dis[end]);
	}
}

class City_1916 implements Comparable<City_1916> {
	int idx;
	int dis;

	City_1916(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}

	@Override
	public int compareTo(City_1916 o) {
		return this.dis - o.dis;
	}
}
