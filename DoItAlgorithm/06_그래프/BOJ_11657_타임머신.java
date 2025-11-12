import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    static int N, M;
    static long[] distance;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Long.MAX_VALUE &&
                        distance[edge.end] > (distance[edge.start] + edge.time)) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean checkCycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > (distance[edge.start] + edge.time)) {
                checkCycle = true;
            }
        }
        if (!checkCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Long.MAX_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(distance[i]);
                    sb.append("\n");
                }
            }
        } else {
            sb.append("-1\n");
        }

        System.out.print(sb.toString());
    }
}

class Edge {
    int start, end, time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}