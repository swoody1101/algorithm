package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ingredients = new int[N];
		for (int i = 0; i < N; i++) {
			ingredients[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ingredients);

		int start = 0;
		int end = N - 1;
		int answer = 0;
		while (start < end) {
			int sum = ingredients[start] + ingredients[end];
			if (sum == M) {
				answer++;
				start++;
				end--;
			} else if (sum < M) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(answer);
	}
}
