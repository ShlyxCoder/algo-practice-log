package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;
/**
 * ? 三数之和
 * 双指针
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;

            for (int i = 0; i < n - 2; i++) {
                if(nums[i] > 0){
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(List.of(nums[i], nums[left], nums[right]));
                        // 跳过重复的 left/right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return res;
        }

    }
}
