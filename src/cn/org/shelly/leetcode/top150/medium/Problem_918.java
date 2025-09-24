package cn.org.shelly.leetcode.top150.medium;

public class Problem_918 {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int total = 0;
            int curMax = 0, maxSum = nums[0];
            int curMin = 0, minSum = nums[0];

            for (int n : nums) {
                total += n;
                curMax = Math.max(curMax + n, n);
                maxSum = Math.max(maxSum, curMax);
                curMin = Math.min(curMin + n, n);
                minSum = Math.min(minSum, curMin);
            }
            if (maxSum < 0) return maxSum;
            return Math.max(maxSum, total - minSum);
        }
    }

}
