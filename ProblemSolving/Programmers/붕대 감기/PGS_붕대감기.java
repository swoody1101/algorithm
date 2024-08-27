package programmers;

public class PGS_붕대감기 {
	
	class Solution {
	    public int solution(int[] bandage, int health, int[][] attacks) {
	        int answer = health;
	        
	        answer -= attacks[0][1];
	        for (int i = 1; i < attacks.length; i++) {
	            int term = attacks[i][0] - attacks[i - 1][0] - 1;
	            if (term > 0) {
	                answer += (term / bandage[0] * bandage[2]) + (term * bandage[1]);
	            }
	            if (answer > health) answer = health;
	            
	            answer -= attacks[i][1];
	            if(answer <= 0) return -1;
	        }
	        
	        return answer;
	    }
	}
}
