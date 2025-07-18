package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 排序数组中查找元素的第一个和最后一个位置
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int i = 0,j = nums.length - 1;
            int [] ret = new int[2];
            int index = 0;
            int res = -1;
            // 找右边界
            while(i <= j){
                index = (i+j)>>1;
                if(nums[index] > target){
                    j = index -1;
                }
                else{
                    if(nums[index] == target) res = index;
                    i = index + 1;
                }
            }
            ret[1] = res;
            i = 0;
            j = nums.length-1;
            res = -1;
            while(i <= j){
                index = (i+j)>>1;
                if(nums[index] < target){
                    i = index + 1;
                }
                else{
                    if(nums[index] == target) res = index;
                    j = index -1;
                }
            }
            ret[0] = res;
            return ret;
        }
    }
}
