package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int result = 0;
		boolean isMinus = false;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '+' || s.charAt(i) == '-') {
				if(isMinus) {
					result -= Integer.parseInt(s.substring(start, i));
				} else {
					result += Integer.parseInt(s.substring(start, i));
				}
				start = i + 1;
				
				if (s.charAt(i) == '-')
					isMinus = true;
			}
		}
		
		if(isMinus) {
			result -= Integer.parseInt(s.substring(start, s.length()));
		} else {
			result += Integer.parseInt(s.substring(start, s.length()));
		}

		System.out.println(result);
	}
}
