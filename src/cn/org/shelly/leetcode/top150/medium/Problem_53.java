package cn.org.shelly.leetcode.top150.medium;

public class Problem_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int max = nums[0];
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
            return max;
        }
    }

}
