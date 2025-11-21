package cn.org.shelly.leetcode.top150.easy;

public class Problem_191 {
    class Solution {
        public int hammingWeight(int n) {
            int ret = 0;
            while(n > 0){
                int bit = n & 1;
                if(bit == 1) ret++;
                n >>= 1;
            }
            return ret;
        }
    }
}
