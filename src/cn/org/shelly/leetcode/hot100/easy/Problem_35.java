package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 搜索插入位置
 * @author shelly
 * @date 2025/7/17
 */
public class Problem_35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int i = 0,j = nums.length;
            while(i < j){
                int mid = (i + j)/2;
                if(target > nums[mid]){
                    i = mid + 1;
                }
                else{
                    j = mid;
                }
            }
            return i;
        }
    }
}
