package programmers.뉴스클러스터링;

import java.util.*;

public class 뉴스클러스터링_v1 {

    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            List<String> list1 = strToList(str1.toLowerCase());
            List<String> list2 = strToList(str2.toLowerCase());
            List<String> intersection = new ArrayList<>();
            List<String> union = new ArrayList<>();

            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    if ((list1.get(i)).equals(list2.get(j))) {
                        intersection.add(list1.remove(i));
                        list2.remove(j);
                        i--;
                        break;
                    }
                }
            }
            union.addAll(list1);
            union.addAll(list2);
            union.addAll(intersection);

            if (union.isEmpty()) return 65536;
            return (65536 * intersection.size()) / union.size();
        }

        List<String> strToList(String str) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length() - 1; i++) {
                String temp = str.substring(i, i + 2);
                if (temp.charAt(0) < 'a' || temp.charAt(0) > 'z' ||
                        temp.charAt(1) < 'a' || temp.charAt(1) > 'z') continue;
                list.add(temp);
            }
            return list;
        }
    }
}
