package cn.org.shelly.leetcode.common.medium;

import java.util.Arrays;
/**
 * ✔ 中位数之和的最大值
 * @author shelly
 * @date 2025/7/27
 */
public class Problem_460_Q1 {
    class Solution {
        public long maximumMedianSum(int[] nums) {
            long ret = 0;
            if(nums.length < 3){
                return 0;
            }
            Arrays.sort(nums);
            int l = 0;
            int r1 = nums.length -1;
            int r2 = nums.length -2;
            while(l < r1){
                ret += nums[r2];
                r2 -= 2;
                r1 -= 2;
                l++;
            }
            return ret;
        }
}}
