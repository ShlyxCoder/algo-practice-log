package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;
/**
 * ✔ 电话号码的字母组合
 * @author shelly
 * @date 2025/7/17
 */
public class Problem_17 {
    class Solution {
        List<String> list = new ArrayList<>();
        Map<Character, String> phoneMap ;
        int length = 0;
        public List<String> letterCombinations(String digits) {
            if(digits.isEmpty()) return list;
            length = digits.length();
            phoneMap = new HashMap<>();
            phoneMap.put('2', "abc");
            phoneMap.put('3', "def");
            phoneMap.put('4', "ghi");
            phoneMap.put('5', "jkl");
            phoneMap.put('6', "mno");
            phoneMap.put('7', "pqrs");
            phoneMap.put('8', "tuv");
            phoneMap.put('9', "wxyz");
            StringBuilder s = new StringBuilder();
            dfs(0,s,digits);
            return list;
        }
        void dfs(int pos, StringBuilder path, String digits){
            if(pos == length){
                list.add(path.toString());
                return;
            }
            String letters = phoneMap.get(digits.charAt(pos));
            for (int i = 0; i < letters.length(); i++) {
                path.append(letters.charAt(i));
                dfs(pos + 1, path, digits);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
