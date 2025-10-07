package cn.org.shelly.leetcode.top150.medium;

public class Problem_151 {
    class Solution {
        public String reverseWords(String s) {
            String[] split = s.split(" ");
            StringBuilder sb = new StringBuilder();

            for (int i = split.length - 1; i >=0; i--) {
                if(split[i].contains(" ")) continue;
                sb.append(split[i]);
            }
            return sb.toString();
        }
    }
}
