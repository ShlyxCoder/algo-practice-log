package cn.org.shelly.leetcode.top150.easy;

public class Problem_190 {
    class Solution {
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res = (res << 1) | (n & 1);
                n >>>= 1;
            }
            return res;
        }
    }

}
