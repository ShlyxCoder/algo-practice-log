package cn.org.shelly.leetcode.top150.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem_77 {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> cur = new ArrayList<>();
            find(cur, n,k,0);
            return list;
        }
        void find(List<Integer> cur, int n, int k, int i){
            if(cur.size() == k){
                list.add(new ArrayList<>(cur));
                return;
            }
            for(;i<n;i++){
                cur.add(i+1);
                find(cur, n,k,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
