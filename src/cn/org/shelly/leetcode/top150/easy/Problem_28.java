package cn.org.shelly.leetcode.top150.easy;

public class Problem_28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.isEmpty()) return 0;
            int n = haystack.length();
            int m = needle.length();
            for (int i = 0; i <= n - m; i++) {
                int j = 0;
                for (; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == m) return i;
            }
            return -1;
        }
    }

}
