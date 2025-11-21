package cn.org.shelly.leetcode.common.easy;

/**
 * 1比特与2比特字符
 */
public class Problem_717 {
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            int n = bits.length;

            while (i < n - 1) {
                if (bits[i] == 1) {
                    i += 2;
                } else {
                    i += 1;
                }
            }
            return i == n - 1;
        }
    }

}
