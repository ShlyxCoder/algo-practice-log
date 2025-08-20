package cn.org.shelly.leetcode.top150.medium;

import java.util.Arrays;

public class Problem_274 {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }
}
