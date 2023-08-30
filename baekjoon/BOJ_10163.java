package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] paper = new int[1001][1001];
		StringTokenizer st;
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + width; j++) {
				for (int k = y; k < y + height; k++) {
					paper[j][k] = cnt;
				}
			}
			cnt++;
		}

		int[] size = new int[cnt];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (paper[i][j] != 0)
					size[paper[i][j]]++;
			}
		}

		for (int i = 1; i < cnt; i++) {
			System.out.println(size[i]);
		}
	}
}
