package programmers.다트게임;

import java.util.*;
public class 다트게임_v1 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            char[] result = dartResult.toCharArray();
            int[] nums = new int[3];
            int cnt = 0;

            for (int i = 0; i < result.length; i++) {
                if (result[i] >= '0' && result[i] <= '9') {
                    if(result[i] == '0' && i != 0 && result[i - 1] == '1') {
                        nums[cnt - 1] = 10;
                        continue;
                    }
                    nums[cnt++] = (int) (result[i] - '0');
                } else if (result[i] == '*') {
                    if((cnt - 2) >= 0) nums[cnt - 2] *= 2;
                    nums[cnt - 1] *= 2;
                } else if (result[i] == '#') {
                    nums[cnt - 1] *= -1;
                } else if (result[i] == 'S') {
                    continue;
                } else if (result[i] == 'D') {
                    nums[cnt - 1] = (int)Math.pow(nums[cnt - 1], 2);
                } else if(result[i] == 'T') {
                    nums[cnt - 1] = (int)Math.pow(nums[cnt - 1], 3);
                }
            }

            for(int i = 0; i < 3; i++) {
                answer += nums[i];
            }
            return answer;
        }
    }
}

