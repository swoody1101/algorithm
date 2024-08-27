package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10973 {

	static int n;
	static Integer[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int target = -1;
		for (int i = n - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				target = i - 1;
				break;
			}
		}
		if (target == -1) {
			System.out.print(-1);
			return;
		}
		
		for (int i = n - 1; i > 0; i--) {
			if(nums[i] < nums[target]) {
				int temp = nums[target];
				nums[target] = nums[i];
				nums[i] = temp;
				break;
			}
		}

		Arrays.sort(nums, target + 1, nums.length, Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
