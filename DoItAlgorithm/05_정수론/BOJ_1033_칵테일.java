package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1033_칵테일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Node>[] graph = new ArrayList[N];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Node>();
		}

		StringTokenizer st;
		long totalmul = 1;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			long gcd = getGCD(p, q);
			p /= gcd;
			q /= gcd;
			graph[a].add(new Node(b, p, q));
			graph[b].add(new Node(a, q, p));
			totalmul *= (p * q);
		}

		long[] result = new long[N];
		boolean[] visit = new boolean[N];
		result[0] = totalmul;
		dfs(graph, result, visit, 0);

		long totalGCD = result[0];
		for (int i = 1; i < result.length; i++) {
			totalGCD = getGCD(totalGCD, result[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			result[i] /= totalGCD;
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	static long getGCD(long a, long b) {
		if (b == 0)
			return a;
		return getGCD(b, a % b);
	}

	static long getLCM(long a, long b) {
		return (a * b) / getGCD(a, b);

	}

	static void dfs(ArrayList<Node>[] graph, long[] result, boolean[] visit, int start) {
		visit[start] = true;

		for (Node n : graph[start]) {
			if (visit[n.t])
				continue;
			result[n.t] = result[start] / n.p * n.q;
			dfs(graph, result, visit, n.t);
		}
	}
}

class Node {
	int t;
	int p;
	int q;

	Node(int t, int p, int q) {
		this.t = t;
		this.p = p;
		this.q = q;
	}
}
