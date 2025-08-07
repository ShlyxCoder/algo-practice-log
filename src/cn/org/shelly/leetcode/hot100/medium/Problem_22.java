package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_22 {
    class Solution {
        private List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            String s = "(";
            StringBuilder sb = new StringBuilder(s.repeat(n));
            dfs(sb,n,0,0);
            return list;
        }
        void dfs(StringBuilder s, int len,int deep,int selected){
            if(s.length() == 2 * len) {
                list.add(new String(s));
                return;
            }
            for(int i = 0;i<s.length();i++){

            }

        }
    }
}
