import java.util.Arrays;
import java.util.Scanner;

/*
input
3 2
1 2 3

output
[1, 2]
[1, 3]
[2, 1]
[2, 3]
[3, 1]
[3, 2]
 */

public class Permutation {

    static int N, R;
    static int[] input, output;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        input = new int[N];
        output = new int[R];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        long start = System.nanoTime();
        permutation(0);
        long end = System.nanoTime();
        System.out.println("basic permutation : " + (end - start));

        start = System.nanoTime();
        permutationUsedFlag(0, 0);
        end = System.nanoTime();
        System.out.println("permutation used Flag : " + (end - start));
    }

    static void permutation(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(output));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            output[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    static void permutationUsedFlag(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(output));
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;
            output[cnt] = input[i];
            permutationUsedFlag(cnt + 1, flag | 1 << i);
        }
    }
}
