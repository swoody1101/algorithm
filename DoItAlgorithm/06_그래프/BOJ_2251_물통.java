package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2251_물통 {

	static int[] fromIdx = { 0, 0, 1, 1, 2, 2 };
	static int[] toIdx = { 1, 2, 0, 2, 0, 1 };
	static int[] volume;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		volume = new int[3];
		for (int i = 0; i < 3; i++) {
			volume[i] = sc.nextInt();
		}
		sc.close();

		boolean[][] visit = new boolean[volume[0] + 1][volume[1] + 1];
		boolean[] result = new boolean[volume[2] + 1];
		bfs(visit, result);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (result[i]) sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}

	static void bfs(boolean[][] visit, boolean[] result) {
		Queue<Bucket> queue = new LinkedList<Bucket>();
		int max = volume[2];
		queue.offer(new Bucket(0, 0));
		visit[0][0] = true;
		result[max] = true;

		while (!queue.isEmpty()) {
			Bucket now = queue.poll();
			
			for (int d = 0; d < 6; d++) {
				int[] next = { now.a, now.b, max - now.a - now.b };
				int from = fromIdx[d];
				int to = toIdx[d];
				if (next[from] <= 0 || next[to] >= volume[to]) continue;

				next[to] += next[from];
				next[from] = 0;
				if (volume[to] < next[to]) {
					next[from] += (next[to] - volume[to]);
					next[to] = volume[to];
				}

				if (visit[next[0]][next[1]]) continue;
				queue.offer(new Bucket(next[0], next[1]));
				visit[next[0]][next[1]] = true;
				if (next[0] == 0) result[next[2]] = true;
			}
		}
	}
}

class Bucket {
	int a;
	int b;

	Bucket(int a, int b) {
		this.a = a;
		this.b = b;
	}
}