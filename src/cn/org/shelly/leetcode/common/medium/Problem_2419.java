package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 按位与最大的最长子数组
 * @author shelly
 * @date 2025/7/30
 */
public class Problem_2419 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int len = 1;
            int max = nums[0];
            int idx = 0;
            while (idx < nums.length){
                int num = nums[idx];
                int j = idx + 1;
                while(j < nums.length && nums[j] == num) j++;
                j--;
                if(num > max) {
                    max = num;
                    len = j - idx + 1;
                    continue;
                } else if (num == max) {
                    len = Math.max(len, j - idx + 1);
                }
                idx = j + 1;
            }
            return len;
        }
    }
}
