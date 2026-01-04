package cn.org.shelly.leetcode.design.sort;

public class QuickSort {
    class Solution {
        public void sortColors(int[] nums) {
            quick_sort(nums,0,nums.length-1);
        }

        private void quick_sort(int[] nums, int left, int right) {
            if(left >= right) return;
            int mid = (left + right) >> 1;
            int stand = nums[mid];
            int i = left - 1, j = right + 1;
            while(i < j){
                do{
                    i++;
                }while(nums[i] < stand);
                do{
                    j--;
                }while(nums[j] > stand);
                if(i < j){
                    int k = nums[i];
                    nums[i] = nums[j];
                    nums[j] = k;
                }
            }
            quick_sort(nums,left,j);
            quick_sort(nums,j+1,right);
        }
    }
}
