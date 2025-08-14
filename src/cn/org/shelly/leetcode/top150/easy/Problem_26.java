package cn.org.shelly.leetcode.top150.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem_26 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int idx = 0;
            Set<Integer> s = new HashSet<>();
            for(int i = 0;i<nums.length;i++){
                if(!s.contains(nums[i])) nums[idx++] = nums[i];
                s.add(nums[i]);
            }
            return idx;
        }
    }
}
