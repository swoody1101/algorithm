package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum == nums[i]) {
					if (i != start && i != end) {
						answer++;
						break;
					} else if (i == start) {
						start++;
					} else if (i == end) {
						end--;
					}
				} else if (sum < nums[i]) {
					start++;
				} else {
					end--;
				}
			}
		}

		System.out.println(answer); 
	}
}
