package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {

	static int N, M, result;
	static ArrayList<Point> houses, chickens;
	static Point[] chickenComb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		chickenComb = new Point[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					houses.add(new Point(i, j));
				} else if (temp == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}

		result = Integer.MAX_VALUE;
		combination(0, 0);

		System.out.println(result);
	}

	static void combination(int cnt, int start) {
		if (cnt == M) {
			result = Math.min(result, getMinDistance());
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			chickenComb[cnt] = chickens.get(i);
			combination(cnt + 1, i + 1);
		}
	}

	static int getMinDistance() {
		int sumDis = 0;
		for (Point house : houses) {
			int minDis = Integer.MAX_VALUE;
			for (int i = 0; i < chickenComb.length; i++) {
				int dis = Math.abs(house.r - chickenComb[i].r) + Math.abs(house.c - chickenComb[i].c);
				minDis = Math.min(minDis, dis);
			}
			sumDis += minDis;
			if (sumDis >= result) {
				return sumDis;
			}
		}
		return sumDis;
	}

	static class Point {

		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
