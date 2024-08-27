package programmers;

public class PGS_이웃한칸 {
	
	int n;
	int[] dh = { 0, 1, 0, -1 };
	int[] dw = { 1, 0, -1, 0 };

	public int solution(String[][] board, int h, int w) {
		int answer = 0;
		n = board.length;
		for (int d = 0; d < 4; d++) {
			int hCheck = h + dh[d];
			int wCheck = w + dw[d];
			if (hCheck >= 0 && hCheck < n && wCheck >= 0 && wCheck < n) {
				if (board[h][w].equals(board[hCheck][wCheck])) answer++;
			}
		}
		return answer;
	}
}
