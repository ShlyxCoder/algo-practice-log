package cn.org.shelly.leetcode.common.medium;

/**
 * ✔ 找出有效子序列的最大长度 II
 * 动态规划
 * @author shelly
 * @date 2025/7/17
 */

public class Problem_3202 {
    class Solution {
        public int maximumLength(int[] nums, int k) {
            int [] count = new int[k];
            int ret = -1;
            for(int i = 0;i<nums.length;i++){
                nums[i] = nums[i] % k;
                ret = Math.max(ret, ++count[nums[i]]);
            }
            int [][] dp = new int[k+1][k+1];
            for(int i = 0;i<nums.length;i++){
                for(int j = 0;j<i;j++){
                    if(nums[i] == nums[j]) continue;
                    dp[nums[j]][nums[i]] = Math.max(dp[nums[j]][nums[i]], dp[nums[i]][nums[j]]+1);
                    dp[nums[j]][nums[i]] = Math.max(dp[nums[j]][nums[i]], dp[k][nums[j]]+1);
                    ret = Math.max(dp[nums[j]][nums[i]], ret);
                }
                dp[k][nums[i]] = 1;
            }
            return ret;
        }
    }
}
/**
 * dp[pre][cur]表示以cur结尾，倒数第二个元素为pre的情况下，最长的子序列长度。
 * 所以要设置成k+1的矩阵大小
 */