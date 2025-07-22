package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;
/**
 * ✔ 分割等和子集
 * 动态规划
 * @author shelly
 * @date 2025/7/22
 */
public class Problem_416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;

            boolean[] dp = new boolean[target + 1];
            Arrays.fill(dp,false);
            dp[0] = true;
            for(int i = 0;i< nums.length;i++){
                for (int j = target; j >= nums[i]; j--) {
                    if (dp[j - nums[i]]) {
                        dp[j] = true;
                    }
                }
            }
            return dp[target];
        }
    }

}
