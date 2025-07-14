package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 两数之和
 * 遍历
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0; i<nums.length;i++){
                for(int j = 0;j<nums.length;j++){
                    if(i == j) continue;
                    if(nums[i] + nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[2];
        }
    }
}
