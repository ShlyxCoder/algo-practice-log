package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 最长公共子序列
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int [][] dp = new int[n][m];
            for(int i = 0;i<n;i++){
                char a = text1.charAt(i);
                for(int j = 0;j<m;j++){
                    char b = text2.charAt(j);
                    if(a == b){
                        if(i >= 1 && j>=1) dp[i][j] = dp[i-1][j-1] + 1;
                        else dp[i][j] = 1;

                    }
                    else{
                        if(i >= 1) dp[i][j] = dp[i-1][j];
                        if(j >= 1) dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
                    }
                }
            }return dp[n-1][m-1];
        }

    }
}
