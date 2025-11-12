package cn.org.shelly.leetcode.top150.medium;

public class Problem_162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    // 中间元素大于右边元素，说明峰值在左边（包括mid）
                    right = mid;
                } else {
                    // 中间元素小于右边元素，说明峰值在右边
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
