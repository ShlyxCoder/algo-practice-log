package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;

import java.util.List;
/**
 * ✔ 括号生成
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_22 {
    class Solution {
        private List<String> list = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            StringBuilder sb = new StringBuilder();
            dfs(sb,n,n);
            return list;
        }
        void dfs(StringBuilder s, int l,int r){
            if(l <0 || r < 0) return;
            if(l == 0 && r == 0){
                list.add(new String(s));
                return ;
            }
            if(l == r){
                s.append('(');
                dfs(s, l-1,r);
                s.delete(s.length() -1, s.length());
            }
            else if(l < r){
                dfs(s.append('('), l-1, r);
                s.delete(s.length() -1, s.length());
                dfs(s.append(')'), l,r-1);
                s.delete(s.length() -1, s.length());
            }
        }
    }
}
