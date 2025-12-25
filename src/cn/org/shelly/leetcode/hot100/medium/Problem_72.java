package cn.org.shelly.leetcode.hot100.medium;

/**
 * 编辑距离
 */
public class Problem_72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            if(n1 * n2 == 0) return n1 + n2;
            int [][] dp = new int [n1 + 1][n2 + 1];
            for(int i = 0;i<=n1;i++) dp[i][0] = i;
            for(int i = 0;i<=n2;i++) dp[0][i] = i;
            for(int i = 1;i<=n1;i++){
                for(int j = 1;j <= n2;j++){
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 删除、插入、替换
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        ) + 1;
                    }
                }
            }
            return dp[n1][n2];
        }
    }
}
