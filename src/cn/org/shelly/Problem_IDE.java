package cn.org.shelly;
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length-1;
        while(i<=j){
            int mid = (i + j) >> 1;
            if(matrix[mid][0] )
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = upperBound(nums,target);
        if(left >= nums.length || nums[left] != target) return new int[]{-1,-1};
        return new int[]{left,right-1};
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
}