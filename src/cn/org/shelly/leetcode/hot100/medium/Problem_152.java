package cn.org.shelly.leetcode.hot100.medium;
/**
 * ？ 乘积最大子数组
 * @author shelly
 * @date 2025/7/23
 */
public class Problem_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int curMax = nums[0];
            int curMin = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                int tempMax = curMax;
                curMax = Math.max(num, Math.max(num * curMax, num * curMin));
                curMin = Math.min(num, Math.min(num * tempMax, num * curMin));
                max = Math.max(max, curMax);
            }
            return max;
        }

    }
}
