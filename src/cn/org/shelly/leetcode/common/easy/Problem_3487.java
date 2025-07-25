package cn.org.shelly.leetcode.common.easy;

import java.util.Arrays;
/**
 * ✔ 删除后的最大子数组元素和
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_3487 {
    class Solution {
        public int maxSum(int[] nums) {
            return (Arrays.stream(nums).distinct().filter(it -> it > 0).sum() == 0) ? Arrays.stream(nums).distinct().max().orElse(-1) : Arrays.stream(nums).distinct().filter(it -> it > 0).sum();
        }
    }
}
