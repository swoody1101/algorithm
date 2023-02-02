import java.util.Arrays;
import java.util.Scanner;

/*
input
4 3
1 2 3 4

output
[1, 2, 3]
[1, 2, 4]
[1, 3, 4]
[2, 3, 4]
 */
public class Combination {

    static int N, R;
    static int[] input, output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        output = new int[R];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        combination(0, 0);
    }

    static void combination(int cnt, int start) {
        if (cnt == R) {
            System.out.println(Arrays.toString(output));
            return;
        }
        for (int i = start; i < N; i++) {
            output[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
