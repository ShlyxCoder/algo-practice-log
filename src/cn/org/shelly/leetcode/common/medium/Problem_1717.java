package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 删除子字符串的最大得分
 * @author shelly
 * @date 2025/7/23
 */
public class Problem_1717 {
    class Solution {
        public int maximumGain(String s, int x, int y) {
            int score = 0;
            char firstA, firstB;
            int high, low;
            if (x > y) {
                firstA = 'a';
                firstB = 'b';
                high = x;
                low = y;
            } else {
                firstA = 'b';
                firstB = 'a';
                high = y;
                low = x;
            }
            score += removePattern(s, firstA, firstB) * high;
            s = removePatternString;
            score += removePattern(s, firstB, firstA) * low;
            return score;
        }

        String removePatternString = "";

        private int removePattern(String s, char first, char second) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (char ch : s.toCharArray()) {
                sb.append(ch);
                int len = sb.length();
                if (len >= 2 && sb.charAt(len - 2) == first && sb.charAt(len - 1) == second) {
                    sb.delete(len - 2, len);
                    count++;
                }
            }
            removePatternString = sb.toString();
            return count;
        }

    }
}
/**
 * 其实，处理低分字符串没必要考虑会合成高分字符串，因为如果ab是高分，对于abab，
 * 那么我们不会先删除中间的低分ba，而是要两个ab
 */