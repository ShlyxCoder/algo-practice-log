package cn.org.shelly.leetcode.common.medium;

/**
 * ✔ 根据质数下标分割数组
 * @author shelly
 * @date 2025/7/26
 */

public class Problem_161_Q1 {
    class Solution {
        public long splitArray(int[] nums) {
            long sum1 = 0, sum2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > 1 && isPrime(i)) sum2 += nums[i];
                else sum1 += nums[i];
            }
            return Math.abs(sum1 - sum2);
        }

        private boolean isPrime(int i) {
            if (i <= 1) return false;
            if (i == 2) return true;
            if (i % 2 == 0) return false;
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) return false;
            }
            return true;
        }
    }

}
