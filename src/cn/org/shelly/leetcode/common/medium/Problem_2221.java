package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 数组的三角和
 * @author shelly
 * @date 2025/9/30
 */
public class Problem_2221 {
    class Solution {
        public int triangularSum(int[] nums) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            while (current.size() > 1) {
                List<Integer> newNums = new ArrayList<>();
                for (int i = 0; i < current.size() - 1; ++i) {
                    newNums.add((current.get(i) + current.get(i + 1)) % 10);
                }
                current = newNums;
            }
            return current.get(0);
        }
    }

}
