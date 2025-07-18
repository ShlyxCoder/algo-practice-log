package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;
/**
 * ✔ 完全平方数
 * 动态规划
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_279 {
    class Solution {
        public int numSquares(int n) {
            int [] dp = new int[n + 1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            for(int i = 0;i<=Math.sqrt(n);i++){
                dp[i*i] = 1;
            }
            for(int i = 2;i<=n;i++){
                for(int j = 1;j<=i/2;j++) dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
            return dp[n];
        }
    }
}
