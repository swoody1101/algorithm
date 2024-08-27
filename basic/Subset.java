import java.util.Scanner;

/*
input
3
1 2 3

output
1 2 3
1 2
1 3
1
2 3
2
3
 */

public class Subset {

    static int N;
    static int[] input;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        subset(0);
    }

    static void subset(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    System.out.print(input[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
    }
}
