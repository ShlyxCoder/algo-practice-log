package cn.org.shelly.leetcode.top150.medium;

public class Problem_63 {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int [][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
            dp[1][1] = (obstacleGrid[0][0] == 0 ? 1 : 0);
            for(int i = 0;i<obstacleGrid.length;i++){
                for (int j = 0; j < obstacleGrid[0].length; j++) {
                    if (i == 0 && j == 0) continue;
                    if(obstacleGrid[i][j] == 1){
                        dp[i+1][j+1] = 0;
                        continue;
                    }
                    dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
                }
            }
            return dp[obstacleGrid.length][obstacleGrid[0].length];
        }
    }

}
