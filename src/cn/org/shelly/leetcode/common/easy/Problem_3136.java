package cn.org.shelly.leetcode.common.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * ✔ 有效单词
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_3136 {
    class Solution {
        public boolean isValid(String word) {
            if(word.length() < 3) return false;
            Set<Character> set = new HashSet<>(List.of('a','e','i','o','u'));
            int count = 0;
            int other = 0;
            for(char c : word.toCharArray()){
                if((c>='0' &&c<='9')){
                    continue;
                }
                if(c>='A'&&c<='Z'){
                    c= Character.toLowerCase(c);
                }
                if(c>='a'&&c<='z'){
                    if(set.contains(c)){
                        count++;
                    }
                    else{
                        other++;
                    }
                }
                else{
                    return false;
                }
            }
            return count >0 && other >0;
        }
    }
}
