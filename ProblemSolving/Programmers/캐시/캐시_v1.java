package programmers.캐시;

import java.util.LinkedList;
import java.lang.String;

public class 캐시_v1 {

    class Solution {

        private static final int CACHE_HIT = 1;
        private static final int CACHE_MISS = 5;

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            LinkedList<String> list = new LinkedList<>();

            for (String city : cities) {
                city = city.toLowerCase();
                if (list.contains(city)) {
                    list.remove(city);
                    list.addFirst(city);
                    answer += CACHE_HIT;
                } else {
                    if (cacheSize > 0) {
                        if (list.size() == cacheSize) {
                            list.removeLast();
                        }
                        list.addFirst(city);
                    }
                    answer += CACHE_MISS;
                }
            }

            return answer;
        }
    }
}
