package cn.org.shelly.leetcode.common.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 统计数组中峰和谷的数量
 * @author shelly
 * @date 2025/7/27
 */
public class Problem_2210 {
    class Solution {
        public int countHillValley(int[] nums) {
            List<Integer> filtered = new ArrayList<>();
            filtered.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    filtered.add(nums[i]);
                }
            }
            int[] array = filtered.stream().mapToInt(Integer::intValue).toArray();

            int count = 0;
            for (int i = 1; i < array.length - 1; i++) {
                if ((array[i] > array[i - 1] && array[i] > array[i + 1]) ||
                        (array[i] < array[i - 1] && array[i] < array[i + 1])) {
                    count++;
                }
            }
            return count;
        }

    }
}
