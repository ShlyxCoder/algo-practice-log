package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 颜色分类
 * @author shelly
 * @date 2025/8/8
 */
public class Problem_75 {
    class Solution {

        public void sortColors(int[] nums) {
            quick_sort(nums,0,nums.length-1);
        }

        private void quick_sort(int[] nums, int left, int right) {
            if(left >= right) return;
            int pivot = nums[(left + right) >> 1];
            int i = left -1, j = right + 1;
            while(i < j) {
                do {
                    i++;
                } while (nums[i] < pivot);
                do {
                    j--;
                } while (nums[j] > pivot);
                if (i < j) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            quick_sort(nums,left,j);
            quick_sort(nums,j+1,right);
        }
    }
}
