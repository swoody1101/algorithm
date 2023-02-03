public class DFS {

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
        dfs(2, 2);
    }

    static void dfs(int nowi, int nowj) {
        visit[nowi][nowj] = true;
        printMap();
        for (int d = 0; d < 4; d++) {
            int ni = nowi + di[d];
            int nj = nowj + dj[d];
            if (ni < 0 || nj < 0 || ni >= 4 || nj >= 4 ||
                    visit[ni][nj] || map[ni][nj] == 1) continue;
            dfs(ni, nj);
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
}
