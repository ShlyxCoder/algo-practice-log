package cn.org.shelly.leetcode.top150.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem_290 {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] ss = s.split(" ");
            if(ss.length != pattern.length()) return false;
            Map<Character, Integer> s2t = new HashMap<>();
            Map<Integer, Character> t2s = new HashMap<>();
            int len = pattern.length();
            for (int i = 0; i < len; ++i) {
                char x = pattern.charAt(i);
                int y = ss[i].hashCode();
                if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                    return false;
                }
                s2t.put(x, y);
                t2s.put(y, x);
            }
            return true;
        }
    }
}
