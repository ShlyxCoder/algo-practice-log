package cn.org.shelly.leetcode.top150.medium;

public class Problem_151 {
        class Solution {
            public String reverseWords(String s) {
                String[] split = s.split(" ");
                StringBuilder sb = new StringBuilder();

                for (int i = split.length - 1; i >=0; i--) {

                    sb.append(split[i]);
                    if(sb.charAt(sb.length() - 1) != ' ') sb.append(" ");


                }
                return sb.toString().trim();
            }
        }
}
