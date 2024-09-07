package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1377_버블소트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Input[] input = new Input[N];
		for (int i = 0; i < N; i++) {
			input[i] = new Input(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(input);

		int result = 0;
		for (int i = 0; i < N; i++) {
			if(result < input[i].index - i ) {
				result = input[i].index - i;
			}
		}
		
		System.out.println(result + 1);
	}
}

class Input implements Comparable<Input> {
	int index;
	int value;

	Input(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Input o) {
		return this.value - o.value;
	}
}
