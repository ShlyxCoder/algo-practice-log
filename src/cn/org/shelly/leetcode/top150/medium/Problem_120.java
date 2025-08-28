package cn.org.shelly.leetcode.top150.medium;

import java.util.List;

public class Problem_120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int [][] dp = new int[triangle.size()][triangle.size()];
            int k = triangle.size();
            dp[0][0] = triangle.get(0).get(0);
            for(int i = 1;i<k;i++){
                for(int j = 0;j<=i;j++){
                    if (j == 0) {
                        // 左边界
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    } else if (j == i) {
                        // 右边界
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {
                        // 中间
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                    }
                }
            }
            int min = 100000000;
            for(int i = 0;i<k;i++){
                if(dp[k-1][i] < min) min = dp[k-1][i];
            }
            return min;

        }
    }
}
