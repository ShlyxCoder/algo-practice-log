package cn.org.shelly.leetcode.common.easy;
/**
 * ✔ 删除字符串使字符串变好
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_1957 {
    class Solution {
        public String makeFancyString(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            int l = 0, r = 0;
            int count = 0;
            while(r < s.length()){
                if(s.charAt(r) == s.charAt(l)){
                    count++;
                }
                else{
                    stringBuilder.append(String.valueOf(s.charAt(l)).repeat(Math.min(count, 2)));
                    l = r;
                    count = 1;
                }
                r++;
            }
            stringBuilder.append(String.valueOf(s.charAt(l)).repeat(Math.min(count, 2)));
            return stringBuilder.toString();
        }
    }
}
