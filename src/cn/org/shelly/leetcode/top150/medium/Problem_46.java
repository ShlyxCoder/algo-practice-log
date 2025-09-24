package cn.org.shelly.leetcode.top150.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem_46 {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        int [] state;
        public List<List<Integer>> permute(int[] nums) {
            state = new int[nums.length];
            fuc(0, nums, new ArrayList<Integer>());
            return list;
        }
        void fuc(int deep, int[] nums, List<Integer> array){
            if(deep == state.length){
                list.add(new ArrayList<>(array));
                return;
            }
            for(int i = 0;i<nums.length;i++){
                if(state[i] == 0){
                    state[i] = 1;
                    array.add(nums[i]);
                    fuc(deep+1, nums, array);
                    state[i] = 0;
                    array.remove(deep);
                }
            }
        }
    }
}
