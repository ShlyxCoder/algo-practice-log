package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ✔ 三数之和
 * @author shelly
 * @date 2025/9/23
 */
public class Problem_LCR007 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0;i<nums.length-2;i++){
                int target = -nums[i];
                int a = i + 1;
                int b = nums.length - 1;
                while(a < b){
                    int cur = nums[a] + nums[b];
                    if(cur > target) b--;
                    if(cur < target) a++;
                    if(cur == target){
                        list.add(List.of(nums[a], nums[b], nums[i]));
                        int idx = a;
                        while(nums[idx] == nums[a] && idx < b) idx++;
                        a = idx;
                    }
                }
                int id = i;
                while(nums[id] == nums[i] && id < nums.length-2) id++;
                i = id -1;
            }
            return list;
        }
    }
}
