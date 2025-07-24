package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;
/**
 * ✔ 划分字母区间
 * @author shelly
 * @date 2025/7/24
 */
public class Problem_763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            Map<Character, Integer> first = new HashMap<>();
            Map<Character, Integer> last = new HashMap<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!first.containsKey(c)) {
                    first.put(c, i);
                }
                last.put(c, i);
            }
            List<int[]> intervals = new ArrayList<>();
            for (char c : first.keySet()) {
                intervals.add(new int[]{first.get(c), last.get(c)});
            }
            intervals.sort(Comparator.comparingInt(a -> a[0]));
            List<Integer> res = new ArrayList<>();
            int start = intervals.get(0)[0], end = intervals.get(0)[1];
            for (int i = 1; i < intervals.size(); i++) {
                int[] cur = intervals.get(i);
                if (cur[0] > end) {
                    res.add(end - start + 1);
                    start = cur[0];
                    end = cur[1];
                } else {
                    end = Math.max(end, cur[1]);
                }
            }
            res.add(end - start + 1);
            return res;
        }
    }
}
