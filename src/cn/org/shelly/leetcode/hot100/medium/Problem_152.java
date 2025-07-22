package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;

public class Problem_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int[] dp = new int[nums.length];
            int [] mdp = new int[nums.length];
            Arrays.fill(dp,Integer.MIN_VALUE);
            Arrays.fill(mdp,Integer.MAX_VALUE);
            dp[0] = nums[0];
            for(int i = 1;i< nums.length;i++){
                dp[i] = Math.max(dp[i-1] * nums[i],nums[i]);

            }
            int max = Integer.MIN_VALUE;
            for(int i = 0;i<dp.length;i++){
                max = Math.max(dp[i],max);
            }
            return max;
        }
    }
}
