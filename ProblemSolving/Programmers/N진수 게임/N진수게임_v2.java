package programmers.N진수게임;

public class N진수게임_v2 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            StringBuilder target = new StringBuilder();
            int num = 0;

            while (target.length() < t * m) {
                target.append(Integer.toString(num++, n));
            }
            for (int i = 0; i < t; i++) {
                answer.append(target.charAt(p - 1 + (i * m)));
            }

            return answer.toString().toUpperCase();
        }
    }
}
