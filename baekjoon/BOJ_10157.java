package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		if ((C * R) < K) {
			System.out.println(0);
			return;
		}

		int[][] map = new int[C][R];
		boolean[][] visit = new boolean[C][R];
		int cnt = 1;
		int x = 0, y = 0, d = 0;
		while (cnt != K) {
			map[x][y] = cnt++;
			visit[x][y] = true;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= C || ny >= R || visit[nx][ny]) {
				d = (d + 1) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
			}
			x = nx;
			y = ny;
		}

		System.out.println((x + 1) + " " + (y + 1));
	}
}
