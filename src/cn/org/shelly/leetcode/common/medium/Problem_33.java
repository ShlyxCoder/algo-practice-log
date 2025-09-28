package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 搜索排序旋转数组
 * @author shelly
 * @date 2025/9/28
 */
public class Problem_33 {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums[mid] == target) return mid;

                // 左半部分有序
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // 右半部分有序
                else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
