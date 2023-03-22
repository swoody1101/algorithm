package programmers.비밀지도;

public class 비밀지도_v2 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String temp;
            for (int i = 0; i < n; i++) {
                temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
                temp = temp.substring(temp.length() - n);
                temp = temp.replace("0", " ");
                temp = temp.replace("1", "#");
                answer[i] = temp;
            }
            return answer;
        }
    }
}


