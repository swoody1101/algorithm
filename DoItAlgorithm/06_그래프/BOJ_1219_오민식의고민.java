import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1219_오민식의고민 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int sCity, eCity;
    static Edge[] edges;
    static int[] incomes;
    static long[] sums;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost);
        }

        incomes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            incomes[i] = Integer.parseInt(st.nextToken());
        }

        sums = new long[N];
        Arrays.fill(sums, Long.MIN_VALUE);

        sums[sCity] = incomes[sCity];
        for (int i = 0; i < N * 2; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (sums[edge.start] == Long.MIN_VALUE) {
                    continue;
                }
                if (sums[edge.start] == Long.MAX_VALUE) {
                    sums[edge.end] = Long.MAX_VALUE;
                } else if (sums[edge.end] < sums[edge.start] + incomes[edge.end] - edge.cost) {
                    sums[edge.end] = sums[edge.start] + incomes[edge.end] - edge.cost;
                    if (i >= N - 1) {
                        sums[edge.end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (sums[eCity] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (sums[eCity] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(sums[eCity]);
        }
    }
}

class Edge {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}
