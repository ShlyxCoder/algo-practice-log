package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;

/**
 * ✔ 跳跃游戏II
 * @author shelly
 * @date 2025/7/24
 */
public class Problem_45 {
    class Solution {
        public int jump(int[] nums) {
            int [] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for(int i = 1;i<nums.length;i++){
                for(int j = 0;j<i;j++){
                    if(dp[j] == Integer.MAX_VALUE) continue;
                    if(i - j <= nums[j]) dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            return dp[nums.length-1];
        }
    }
}
