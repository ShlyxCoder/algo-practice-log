package cn.org.shelly.leetcode.top150.medium;

public class Problem_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int [] arr = new int[2];
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            if(left == nums.length || nums[left] != target){
                arr[0] = -1;
                arr[1] = -1;
                return arr;
            }
            arr[0] = left;
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            arr[1] = right;
            return arr;
        }
    }
}
