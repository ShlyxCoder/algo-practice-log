package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 移动0
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int j = nums.length-1;
            while(i<j){
                while(nums[j] != 0) j--;
                int a = nums[i];
                if(a!=0){
                    i++;
                    continue;
                }
                int c = nums[j];
                nums[j] = a;
                nums[i] = c;
                j--;
            }
        }
    }

}
