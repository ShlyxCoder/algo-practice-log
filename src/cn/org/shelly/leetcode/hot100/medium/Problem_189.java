package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 轮转数组
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int [] tmp = new int[nums.length];
            for(int i = 0;i<nums.length;i++){
                tmp[(i+k)%nums.length] = nums[i];
            }
            for(int i = 0;i<nums.length;i++){
                nums[i] = tmp[i];
            }
        }
    }
}
