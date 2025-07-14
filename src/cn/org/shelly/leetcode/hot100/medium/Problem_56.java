package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * ✔ 合并区间
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int[][] sorted = Arrays.stream(intervals)
                    .sorted(Comparator.comparingInt(a -> a[0]))
                    .toArray(int[][]::new);

            List<int[]> list = new ArrayList<>();
            int left = sorted[0][0], right = sorted[0][1];

            for (int i = 1; i < sorted.length; i++) {
                int a = sorted[i][0];
                int b = sorted[i][1];

                if (a > right) {
                    list.add(new int[]{left, right});
                    left = a;
                    right = b;
                } else {
                    right = Math.max(right, b);
                }
            }
            list.add(new int[]{left, right});
            return list.toArray(new int[list.size()][]);
        }
    }

}
