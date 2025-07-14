package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 最大子数组和
 * @author shelly
 * @date 2025/7/14
 */
public class problem_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            if(nums.length == 1) return max;
            int cur = 0;
            for(int i = 0;i< nums.length;i++){
                int tmp = nums[i];
                if(tmp > 0 && cur <= 0){
                    cur = 0;
                }
                cur += tmp;
                max = Math.max(Math.max(max, tmp), cur);
            }
            return max;
        }
    }
}
