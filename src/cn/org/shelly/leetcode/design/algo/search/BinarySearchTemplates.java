package cn.org.shelly.leetcode.design.algo.search;

public class BinarySearchTemplates {

    public int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        return -1;
    }

    public int lowerBound(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;  // i 即为第一个 >= target 的位置
    }

    public int upperBound(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;  // i 即为第一个 > target 的位置
    }
    public static void main(String[] args){
        //// 第一个 >= target
        //int ge = lowerBound(nums, target);
        //
        //// 第一个 > target
        //int gt = upperBound(nums, target);
        //
        //// 最后一个 < target
        //int lt = lowerBound(nums, target) - 1;
        //
        //// 最后一个 <= target
        //int le = upperBound(nums, target) - 1;
    }
}
