package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 移动0
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int zero = 0;
            int idx = 0;
            for(int i = 0;i< nums.length;i++){
                if(nums[i] == 0){
                    zero++;
                }
                else{
                    nums[idx++] = nums[i];
                }
            }
            for(int i = nums.length-1;zero >0 && i>=0 ;zero--,i--){
                nums[i] =0;
            }
        }
    }

}
