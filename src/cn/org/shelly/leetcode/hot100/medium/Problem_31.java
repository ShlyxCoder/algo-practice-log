package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;
/**
 * ✔ 下一个排列
 * @author shelly
 * @date 2025/8/8
 */
public class Problem_31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int idx = -1;
            int pre = nums[nums.length-1];
            for(int i = nums.length - 2;i>=0;i--){
                if(nums[i] < pre){
                    idx = i;
                    break;
                }
                pre = nums[i];
            }
            System.out.println(idx);
            if(idx != -1){
                for(int i = nums.length-1;i>idx;i--){
                    if(nums[i] > nums[idx]){
                        int tmp = nums[i];
                        nums[i] = nums[idx];
                        nums[idx] = tmp;
                        break;
                    }
                }
            }
            Arrays.sort(nums, idx + 1, nums.length);
        }
    }
}
