package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 1&0
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int [][] count = new int[strs.length][2];
            for(int i = 0;i<strs.length;i++){
                String s = strs[i];
                int z = 0;
                int o = 0;
                for(int j = 0;j<s.length();j++){
                    if(s.charAt(j) == '0') z++;
                    else o++;
                }
                count[i][0] = z;
                count[i][1] = o;
            }
            int [][] dp = new int [m+1][n+1];
            for (int[] ints : count) {
                int z = ints[0];
                int o = ints[1];
                if (z > m || o > n) continue;
                for (int j = m; j >= 0; j--) {
                    for (int k = n; k >= 0; k--) {
                        if (j >= z && k >= o) {
                            dp[j][k] = Math.max(dp[j][k], dp[j - z][k - o] + 1);
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
/**
 * 必须倒序，不然会覆盖掉
 */
