package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 문자열 str중에 2가지 알바벳만 가진 가장 긴 길이
 *
 * input :
 *     str = "ccaabba"
 *
 * output : 5
 * */

public class LongestSubMostTwoDist {

    public static void main(String[] args) {
        String str = "ccaabba";
        System.out.println(new LongestSubMostTwoDist().solve(str));
    }

    public int solve(String str) {
        int start = 0, end = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < str.length()) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            end++;

            while (map.size() > 2) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) map.remove(startChar);
                start++;
            }

            max = Math.max(max, end - start);
        }
        return max;
    }

    int solve2(String str) {
        Set<Character> set = new HashSet<>();

        int start = 0;
        int max = 0;
        int nextIndex = 0;
        boolean firstSizeOne = false;
        boolean firstSizeTow = false;

        for (int i = 0; i < str.length(); i++) {

            set.add(str.charAt(i));
            if (set.size() > 2) {
                set = new HashSet<>();
                max = Math.max(i - start + 1, max);
                i = nextIndex - 1;
                firstSizeOne = false;
                firstSizeTow = false;
                continue;
            } else if (set.size() == 1 && !firstSizeOne) {
                firstSizeOne = true;
                start = i;
            } else if (set.size() == 2 && !firstSizeTow) {
                firstSizeTow = true;
                nextIndex = i;
            } else if (set.size() == 2 && i == str.length() - 1) {
                max = Math.max(i - start, max);
            }
            System.out.println(start + "," + i);
        }
        return max;
    }
}