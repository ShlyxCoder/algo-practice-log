package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;
/**
 * ✔ 零钱兑换
 * 动态规划
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

}
