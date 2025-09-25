package cn.org.shelly.leetcode.top150.medium;

public class Problem_912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            my_sort(0, nums.length-1,nums);
            return nums;
        }
        void my_sort(int l, int r , int[] nums){
            if(l>=r) return ;
            int standard = nums[(l+r)>>1];
            int i = l -1;
            int j = r + 1;
            while(i<j){
                do{
                    i++;
                }while(nums[i] < standard);
                do{
                    j--;
                }while(nums[j] >= standard);
                if(i<j){
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                }
            }
            my_sort(l, j, nums);
            my_sort(j+1,r,nums);
        }
    }
}
