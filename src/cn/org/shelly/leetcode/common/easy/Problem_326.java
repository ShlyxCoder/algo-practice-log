package cn.org.shelly.leetcode.common.easy;
/**
 * ✔ 3的幂
 * @author shelly
 * @date 2025/8/13
 */
public class Problem_326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }
    }
}
