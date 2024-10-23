package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1948_임계경로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] indegree = new int[N + 1];
		ArrayList<City>[] A = new ArrayList[N + 1];
		ArrayList<Integer>[] R = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<City>();
			R[i] = new ArrayList<Integer>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			A[from].add(new City(to, dis));
			R[to].add(from);
			indegree[to]++;
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Set<Integer>[] set = new HashSet[N + 1];
		for (int i = 1; i <= N; i++) {
			set[i] = new HashSet<Integer>();
		}
		int[] maxDis = new int[N + 1];
		Queue<City> queue = new LinkedList<City>();
		queue.offer(new City(start, 0));
		while (!queue.isEmpty()) {
			City now = queue.poll();
			int nowIdx = now.idx;
			int nowDis = now.dis;
			for (City next : A[nowIdx]) {
				int nextIdx = next.idx;
				int nextDis = nowDis + next.dis;
				if (nextDis > maxDis[nextIdx]) {
					set[nextIdx].clear();
					set[nextIdx].add(nowIdx);
					maxDis[nextIdx] = nextDis;
					queue.offer(new City(nextIdx, nextDis));
				} else if (nextDis == maxDis[nextIdx]) {
					set[nextIdx].add(nowIdx);
				}
			}
		}

		int roadCnt = 0;
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> road = new LinkedList<Integer>();
		road.offer(end);
		while (!road.isEmpty()) {
			int now = road.poll();
			for (int next : set[now]) {
				roadCnt++;
				if (!visit[next]) {
					visit[next] = true;
					road.offer(next);
				}
			}
		}

		System.out.println(maxDis[end]);
		System.out.println(roadCnt);
	}
}

class City {
	int idx;
	int dis;

	City(int idx, int dis) {
		this.idx = idx;
		this.dis = dis;
	}
}
