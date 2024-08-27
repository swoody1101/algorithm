import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    static int N, input[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        long start = System.nanoTime();
        Arrays.sort(input);
        do {
            // 순열 출력
            // System.out.println(Arrays.toString(input));
        } while (nextPermutation());
        long end = System.nanoTime();
        System.out.println(end - start);

    }

    // 현재 자리에 수 뽑기
    public static boolean nextPermutation() {
        // 1. 교환위치 찾기
        int i = N - 1;
        while (i > 0 && input[i - 1] >= input[i])
            --i;
        if (i == 0)
            return false;

        // 2. 교환위치에 교환할 값 찾기
        int j = N - 1;
        while (input[i - 1] >= input[j])
            --j;

        // 3. 교환 위치와 교환할 값 교환하기
        swap(i - 1, j);

        // 4. 교환위치 뒤(꼭대기)부터 맨 뒤까지 만들수 있는 가장 작은 순열 생성(오름차순정렬)
        int k = N - 1;
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    public static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
