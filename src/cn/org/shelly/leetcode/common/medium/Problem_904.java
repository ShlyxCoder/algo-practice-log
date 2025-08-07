package cn.org.shelly.leetcode.common.medium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Problem_904 {
    class Solution {
        public int totalFruit(int[] fruits) {
            if(fruits.length < 2) return 2;
            int max = -1;
            int l = 0, r = 0;
            Set<Integer> set = new LinkedHashSet<>();
            while (r < fruits.length) {
                if(set.contains(fruits[r]) || set.size() < 2) set.add(r);
                else{
                    int tmp = set.iterator().next();
                    set.remove(set.iterator().next());
                    l = tmp;
                    set.add(r);
                }
                r++;
                max = Math.max(max, r - l);
            }
            return max;
        }
    }
}
