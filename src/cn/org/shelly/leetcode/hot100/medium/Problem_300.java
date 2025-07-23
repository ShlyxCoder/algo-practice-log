package cn.org.shelly.leetcode.hot100.medium;

/**
 * ✔ 最长递增子序列
 * @author shelly
 * @date 2025/7/23
 */
public class Problem_300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int [] dp = new int[nums.length];
            dp[0] = 1;
            for(int i = 1;i<nums.length;i++){
                dp[i] = 1;
                for(int j = 0;j<i;j++){
                    if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int max = -1;
            for(int i = 0;i<dp.length;i++){
                if(dp[i] > max) max = dp[i];
            }
            return max;
        }
    }
}
