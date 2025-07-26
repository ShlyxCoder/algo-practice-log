package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 组合总数
 * @author shelly
 * @date 2025/7/26
 */
public class Problem_39 {
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, target, new ArrayList<>(), 0, 0);
            return ret;
        }

        private void dfs(int[] candidates, int target, List<Integer> list, int sum, int start) {
            if (sum == target) {
                ret.add(new ArrayList<>(list));
                return;
            }
            if (sum > target) return;

            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(candidates, target, list, sum + candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }

}
