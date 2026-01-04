package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 最小路径和
 * @author shelly
 * @date 2025/7/24
 */
public class Problem_64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j-1] + grid[0][j];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
            return dp[m-1][n-1];
        }
        private void printOps(String w1, String w2, int[][] dp) {
            int i = w1.length();
            int j = w2.length();

            while (i > 0 || j > 0) {

                // ↖ 左上：匹配 或 替换
                if (i > 0 && j > 0) {
                    if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
                        System.out.println("Match");
                        i--;
                        j--;
                        continue;
                    }
                    if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                        System.out.println("Replace");
                        i--;
                        j--;
                        continue;
                    }
                }

                // ↑ 上：删除
                if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                    System.out.println("Delete");
                    i--;
                    continue;
                }

                // ← 左：插入
                System.out.println("Insert");
                j--;
            }
        }

    }
}
