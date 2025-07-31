package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 相临值的按位亦或
 * @author shelly
 * @date 2025/7/31
 */
public class Problem_2683 {
    class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int memo = 0;
            for (int num : derived) {
                memo ^= num;
            }
            return memo == 0;
        }
    }
}
