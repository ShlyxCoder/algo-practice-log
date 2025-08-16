package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashMap;
import java.util.Map;
/**
 * ✔ 和为K的子数组
 * 前缀和
 * @author shelly
 * @date 2025/8/16
 */
public class Problem_560 {
     static class Solution {
         public int subarraySum(int[] nums, int k) {
             Map<Integer, Integer> prefixCount = new HashMap<>();
             prefixCount.put(0, 1);

             int sum = 0;
             int count = 0;

             for (int num : nums) {
                 sum += num;
                 if (prefixCount.containsKey(sum - k)) {
                     count += prefixCount.get(sum - k);
                 }
                 prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
             }

             return count;
         }

    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(new Solution().subarraySum(nums, 3));
    }
}
