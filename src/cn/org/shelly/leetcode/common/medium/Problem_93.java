package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 复原IP地址
 * @author shelly
 * @date 2025/9/11
 */
public class Problem_93 {
    class Solution {
        List<String> ret = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            if(s.length()<4) return ret;
            List<String> list = new ArrayList<>();
            dfs(s, 0, list);
            return ret;
        }
        private void dfs(String s, int start, List<String> res) {
            if(res.size() == 4 && start == s.length()){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i< 4;i++){
                    sb.append(res.get(i));
                    if(i!=3) sb.append('.');
                }
                ret.add(sb.toString());
                return;
            }
            for(int i = 0;i<3;i++){
                if (start + i >= s.length()) break;
                String tmp = s.substring(start, start + 1 + i);
                int num = Integer.parseInt(tmp);
                if ((tmp.length() > 1 && tmp.startsWith("0")) || num > 255) continue;
                res.add(tmp);
                dfs(s, start+i+1, res);
                res.remove(res.size()-1);
            }
        }
    }
}
