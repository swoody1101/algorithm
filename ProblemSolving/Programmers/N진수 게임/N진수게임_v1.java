package programmers.N진수게임;

public class N진수게임_v1 {

    class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder answer = new StringBuilder();
            int num = 0;
            int cnt = 0;
            int now = p;
            String s = changeNum(num++, n);
            while (cnt < t) {
                if (s.length() < now) {
                    now -= s.length();
                    s = changeNum(num++, n);
                } else {
                    answer.append(s.substring(now - 1, now));
                    cnt++;
                    s = s.substring(now);
                    now = m;
                }
            }

            return answer.toString();
        }

        private String changeNum(int num, int n) {
            if (num < n) {
                if (num >= 10) return toAlpha(num, n);
                return Integer.toString(num);
            }
            if ((n > 10) && (num % n >= 10)) {
                return changeNum(num / n, n).concat(toAlpha(num, n));
            }
            return changeNum(num / n, n).concat(Integer.toString(num % n));
        }

        private String toAlpha(int num, int n) {
            return Character.toString((char) ('A' + (num % n) - 10));
        }
    }
}
