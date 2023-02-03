import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int[][] map = {
            {9, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 0, 7, 0},
            {0, 1, 0, 1}
    };
    static boolean[][] visit = new boolean[4][4];

    public static void main(String[] args) {
        bfs(2, 2);
    }

    static void bfs(int si, int sj) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(si, sj));
        visit[si][sj] = true;
        while (!queue.isEmpty()) {
            printMap();
            Point now = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];
                if (ni < 0 || nj < 0 || ni >= 4 || nj >= 4 || visit[ni][nj] || map[ni][nj] != 0) continue;
                visit[ni][nj] = true;
                queue.add(new Point(ni, nj));
            }
        }
    }

    static void printMap() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(visit[i][j] ? "*" : "0");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    static class Point {

        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
