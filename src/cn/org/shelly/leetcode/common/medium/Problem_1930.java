package cn.org.shelly.leetcode.common.medium;

import java.util.HashSet;

public class Problem_1930 {
    class Solution {
        public int countPalindromicSubsequence(String s) {
            int ret = 0;
            for(int i = 0;i<26;i++){
                HashSet<Character> c = new HashSet<>();
                char tmp = (char) ('a' + i);
                int left = 0;
                while(left < s.length() && s.charAt(left) != tmp)left++;
                left++;
                int right = s.length() -1 ;
                while(right >= 0 && s.charAt(right) != tmp)right--;
                if(left>=right)continue;
                for(;left<right;left++){
                    char now = s.charAt(left);
                    c.add(now);
                }
                ret += c.size();
            }
            return ret;
        }
    }
}
