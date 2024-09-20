package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(map, visit));
	}

	static int bfs(int[][] map, boolean[][] visit) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1));
		visit[0][0] = true;

		int result = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				int ndis = now.dis + 1;

				if (nx < 0 || ny < 0 || nx >= N || ny >= M 
						|| map[nx][ny] == 0 || visit[nx][ny]) continue;
				if (nx == N - 1 && ny == M - 1) {
					if (result > ndis)
						result = ndis;
				}
				queue.offer(new Point(nx, ny, ndis));
				visit[nx][ny] = true;
			}
		}

		return result;
	}
}

class Point {
	int x;
	int y;
	int dis;

	Point(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
