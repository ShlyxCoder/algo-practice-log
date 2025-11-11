package cn.org.shelly.leetcode.top150.easy;

public class Problem_13 {
    class Solution {
        private static final int[] vals = new int[128];
        static {
            vals['I'] = 1;
            vals['V'] = 5;
            vals['X'] = 10;
            vals['L'] = 50;
            vals['C'] = 100;
            vals['D'] = 500;
            vals['M'] = 1000;
        }
        public int romanToInt(String s) {
            int sum = 0;
            int prev = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = vals[s.charAt(i)];
                sum += (curr < prev ? -curr : curr);
                prev = curr;
            }
            return sum;
        }

    }

}
