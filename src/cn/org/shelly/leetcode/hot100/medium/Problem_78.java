package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ✔ 子集
 * dfs
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_78 {
    class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> list = new ArrayList<>();
            dfs(nums,0,list);
            return result;
        }
        void dfs(int[] nums, int index, List<Integer> list){
            result.add(new ArrayList<>(list));
            for(;index<nums.length;index++){
                list.add(nums[index]);
                dfs(nums,index+1,list);
                list.remove(list.size()-1);
            }
        }


    }
}
