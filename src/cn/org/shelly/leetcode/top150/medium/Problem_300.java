package cn.org.shelly.leetcode.top150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_300 {
    class Solution {
        public List<Integer> lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];       // dp[i] 表示以 nums[i] 结尾的 LIS 长度
            int[] prev = new int[n];     // prev[i] 记录 nums[i] 的前驱索引
            Arrays.fill(dp, 1);
            Arrays.fill(prev, -1);

            int maxLen = 1;
            int lastIndex = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    lastIndex = i;
                }
            }

            // 回溯 LIS
            List<Integer> lis = new ArrayList<>();
            int k = lastIndex;
            while (k != -1) {
                lis.add(nums[k]);
                k = prev[k];
            }
            Collections.reverse(lis);
            return lis;
        }

        public void main(String[] args) {
            Solution sol = new Solution();
            int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
            List<Integer> res = sol.lengthOfLIS(nums);
            System.out.println("最长递增子序列: " + res);
        }
    }
}
