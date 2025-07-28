package cn.org.shelly.leetcode.common.medium;

import java.util.HashMap;
import java.util.Map;
/**
 * ✔ 统计按位或能得到最大值的子集数目
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_2044 {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] state;

        public int countMaxOrSubsets(int[] nums) {
            state = new boolean[nums.length];
            dfs(nums, 0, 0);

            int maxOr = 0;
            for (int key : map.keySet()) {
                maxOr = Math.max(maxOr, key);
            }
            return map.get(maxOr);
        }

        private void dfs(int[] nums, int idx, int pre) {
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            for (int i = idx; i < nums.length; i++) {
                if (!state[i]) {
                    state[i] = true;
                    dfs(nums, i + 1, pre | nums[i]);
                    state[i] = false;
                }
            }
        }
    }

}
