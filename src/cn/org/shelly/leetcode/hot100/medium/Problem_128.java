package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * ✔ 最长连续序列
 * set
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ret = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int tmp = num;
                int length = 1;

                while (set.contains(tmp + 1)) {
                    tmp++;
                    length++;
                }

                ret = Math.max(ret, length);
            }
        }

        return ret;
    }

}
