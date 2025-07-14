package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ✔ 全排列
 * dfs
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_46 {
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();
        int length;
        List<Integer> list ;
        boolean [] state;
        public List<List<Integer>> permute(int[] nums) {
            list = new ArrayList<>(nums.length);
            length = nums.length;
            state = new boolean[length];
            Arrays.fill(state,false);
            for (int i = 0; i < nums.length; i++) {
                list.add(0);
            }
            dfs(0,nums);
           return ret;
        }
        void dfs(int pos, int[] nums){
            if(pos == length){
                ret.add(new ArrayList<>(list));
                return;
            }
            for(int i=0;i<length;i++){
                if(!state[i]){
                    state[i]=true;
                    list.set(pos, nums[i]);
                    dfs(pos+1,nums);
                    state[i]=false;
                }
        }

    }}
}
