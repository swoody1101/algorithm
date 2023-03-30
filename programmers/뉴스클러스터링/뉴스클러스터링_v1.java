package programmers.뉴스클러스터링;

public class 뉴스클러스터링_v1 {

    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            int[] dx = {0, 1, 0, 1};
            int[] dy = {0, 0, 1, 1};
            char[][] cBoard = new char[m][n];
            boolean trigger = true;
            boolean[][] delete;

            for (int i = 0; i < m; i++) {
                cBoard[i] = board[i].toCharArray();
            }

            while (trigger) {
                trigger = false;
                delete = new boolean[m][n];
                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (cBoard[i][j] == ' ' ||
                                cBoard[i][j] != cBoard[i + dx[1]][j + dy[1]] ||
                                cBoard[i][j] != cBoard[i + dx[2]][j + dy[2]] ||
                                cBoard[i][j] != cBoard[i + dx[3]][j + dy[3]]) continue;
                        trigger = true;
                        for (int d = 0; d < 4; d++) {
                            delete[i + dx[d]][j + dy[d]] = true;
                        }
                    }
                }
                answer += deleteBlock(cBoard, delete, m, n);
                dropBlock(cBoard, m, n);
            }

            return answer;
        }

        int deleteBlock(char[][] cBoard, boolean[][] delete, int m, int n) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (delete[i][j]) {
                        cBoard[i][j] = ' ';
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        void dropBlock(char[][] cBoard, int m, int n) {
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (cBoard[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (cBoard[k][j] != ' ') {
                                cBoard[i][j] = cBoard[k][j];
                                cBoard[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
