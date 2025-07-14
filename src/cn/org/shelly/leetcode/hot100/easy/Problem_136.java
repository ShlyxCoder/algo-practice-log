package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 只出现一次的数字
 * 遍历
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int num = nums[0];
            for(int i = 1;i<nums.length;i++){
                num  = num ^ nums[i];
            }
            return num;
        }
    }
}


