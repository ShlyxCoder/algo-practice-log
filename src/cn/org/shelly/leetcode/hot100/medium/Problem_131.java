package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 分割回文串
 * @author shelly
 * @date 2025/8/7
 */
public class Problem_131 {
    class Solution {
        List<List<String>> ret = new ArrayList<>();

        public List<List<String>> partition(String s) {
            dfs(s, 0, new ArrayList<>());
            return ret;
        }

        void dfs(String s, int begin, List<String> list) {
            if (begin == s.length()) {
                ret.add(new ArrayList<>(list));
                return;
            }

            for (int j = begin; j < s.length(); j++) {
                if (check(begin, j, s)) {
                    list.add(s.substring(begin, j + 1));
                    dfs(s, j + 1, list);
                    list.remove(list.size() - 1);
                }
            }
        }

        boolean check(int l, int r, String s) {
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
