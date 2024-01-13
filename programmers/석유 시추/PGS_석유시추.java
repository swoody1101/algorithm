package programmers;
import java.util.*;

public class PGS_석유시추 {

	class Solution {
	    
	    int[] dx = { -1, 0, 1, 0 };
	    int[] dy = { 0, -1, 0, 1 };
	    int n, m;
	    int[][] oil, land;
	    boolean[][] visit;
	    
	    public int solution(int[][] land) {
	        int answer = 0;
	        n = land.length;
	        m = land[0].length;
	        this.land = land;
	        oil = new int[n][m];
	        visit = new boolean[n][m];
	        
	        int oilId = 1;
	        Map<Integer, Integer> oilMap = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (land[i][j] == 1 && !visit[i][j]) {
	                    int oilSize = bfs(i, j, oilId);
	                    oilMap.put(oilId, oilSize);
	                    oilId++;
	                } 
	            }
	        }        
	        
	        boolean[] visitOilMap;
	        int oilSum = 0;
	        for (int j = 0; j < m; j++) {
	            visitOilMap = new boolean[oilId];
	            oilSum = 0;
	            for (int i = 0; i < n; i++) {
	                int id = oil[i][j];
	                if (id != 0 && !visitOilMap[id]) {
	                    oilSum += oilMap.get(id);
	                    visitOilMap[id] = true;
	                }
	            }
	            if (answer < oilSum) answer = oilSum;
	        }
	        
	        return answer;
	    }
	    
	    private int bfs(int x, int y, int oilId) {
	        Queue<Point> queue = new LinkedList<>();
	        queue.offer(new Point(x, y));
	        visit[x][y] = true;
	        oil[x][y] = oilId;
	        int oilSize = 1;
	        
	        while (!queue.isEmpty()) {
	            Point now = queue.poll();
	            for (int d = 0; d < 4; d++) {
	                int nx = now.x + dx[d];
	                int ny = now.y + dy[d];
	                if (nx >= 0 && ny >= 0 && nx < n && ny < m
	                   && !visit[nx][ny] && land[nx][ny] == 1) {
	                    queue.offer(new Point(nx, ny));
	                    visit[nx][ny] = true;
	                    oil[nx][ny] = oilId;
	                    oilSize++;
	                };
	            }
	        }
	        
	        return oilSize;
	    }
	}

	class Point {
	    
	    int x;
	    int y;
	    
	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
}
