package cn.org.shelly.leetcode.hot100.easy;

import java.util.*;
/**
 * ✔ 有效的括号
 * @author shelly
 * @date 2025/7/16
 */
public class Problem_20 {
    class Solution {
        public boolean isValid(String s) {
            if(s.length() < 2) return false;
            Map<Character,Character> map = new HashMap<>();
            map.put('(',')');
            map.put('{','}');
            map.put('[',']');
            Set<Character> set = map.keySet();
            Stack<Character> stack = new Stack<>();
            for(Character c : s.toCharArray()){
                if(set.contains(c)) stack.push(c);
                else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    Character tmp = stack.peek();
                    Character should = map.get(tmp);
                    if(Objects.equals(should, c)) {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
