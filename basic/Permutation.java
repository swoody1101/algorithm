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
        permutation(0);
    }

    static void permutation(int cnt) {
        if(cnt == R) {
            System.out.println(Arrays.toString(output));
            return;
        }
        for(int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            output[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
