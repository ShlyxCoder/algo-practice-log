package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 寻找旋转排序数组中的最小值
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_153 {
    class Solution {
        int min = Integer.MAX_VALUE;
        public int findMin(int[] nums) {
            fuc(nums, 0 , nums.length-1);
            return min;
        }

        private void fuc(int[] nums, int i, int i1) {
            if(nums[i] <= nums[i1]){
                min = Math.min(min,nums[i]);
                return;
            }
            if(i >= i1){
                return;
            }
            int mid = (i + i1) >> 1;
            fuc(nums,i,mid);
            fuc(nums,mid+1,i1);
        }
    }
}
