package cn.org.shelly.leetcode.common.medium;

import java.util.HashMap;
import java.util.Map;
/**
 * ✔ 水果成篮
 * @author shelly
 * @date 2025/8/10
 */
public class Problem_904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            int l = 0, r = 0;
            Map<Integer, Integer> m = new HashMap<>();
            int ret = 0, size = 0;

            while (r < fruits.length) {
                int cur = fruits[r];
                m.put(cur, m.getOrDefault(cur, 0) + 1);
                size++;
                while (m.size() > 2) {
                    int leftFruit = fruits[l];
                    m.put(leftFruit, m.get(leftFruit) - 1);
                    if (m.get(leftFruit) == 0) {
                        m.remove(leftFruit);
                    }
                    size--;
                    l++;
                }
                ret = Math.max(ret, size);
                r++;
            }
            return ret;
        }
    }
}
