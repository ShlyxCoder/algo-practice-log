package cn.org.shelly.leetcode.hot100.hard;

import java.util.HashMap;
import java.util.Map;
/**
 * ✔ 最小覆盖子串
 * @author shelly
 * @date 2025/8/7
 */
public class Problem_76 {
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";

            Map<Character, Integer> target = new HashMap<>();
            for (char c : t.toCharArray()) {
                target.put(c, target.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int count = 0;
            int minLen = Integer.MAX_VALUE;
            int start = 0;

            Map<Character, Integer> window = new HashMap<>();

            while (right < s.length()) {
                char c = s.charAt(right);
                if (target.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).intValue() == target.get(c).intValue()) {
                        count++;
                    }
                }
                while (count == target.size()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        start = left;
                    }

                    char d = s.charAt(left);
                    if (target.containsKey(d)) {
                        window.put(d, window.get(d) - 1);
                        if (window.get(d) < target.get(d)) {
                            count--;
                        }
                    }
                    left++;
                }

                right++;
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }

}
