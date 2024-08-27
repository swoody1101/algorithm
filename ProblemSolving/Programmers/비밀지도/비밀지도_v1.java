package programmers.비밀지도;

public class 비밀지도_v1 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for(int i = 0; i < n; i++) {
                int[] bin1 = new int[n];
                int[] bin2 = new int[n];
                bin1 = toBinaryArray(bin1, arr1[i]);
                bin2 = toBinaryArray(bin2, arr2[i]);
                answer[i] = checkMap(bin1, bin2);
            }
            return answer;
        }

        int[] toBinaryArray(int[] bin, int num) {
            for(int i = bin.length - 1; i >= 0; i--) {
                bin[i] = (num < 1) ? num : num % 2;
                num /= 2;
            }
            return bin;
        }

        String checkMap(int[] bin1, int[] bin2) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bin1.length; i++) {
                sb.append((bin1[i] == 0 && bin2[i] == 0) ? " " : "#");
            }
            return sb.toString();
        }
    }
}


