package cn.org.shelly.leetcode.hot100.medium;

public class Problem_5 {
    class Solution {
        public String longestPalindrome(String s) {
            int max = -1;
            int idx = 0;
            for(int i = 0;i<s.length();i++){
                int l = i - 1;
                int r = i + 1;
                int len = 1;
                while(l >= 0 && r < s.length()){

                }
                if(len > max) {
                    max = len;
                    idx = i;
                }
            }
            return null;
        }
    }
}
