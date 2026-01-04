package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 复原IP地址
 * @author shelly
 * @date 2025/9/11
 */
class Solution {
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return list;
        dfs(s, 0, new ArrayList<>());
        return list;
    }

    void dfs(String s, int begin, List<String> cur){
        // 已经分了4段
        if(cur.size() == 4){
            if(begin == s.length()){
                list.add(String.join(".", cur));
            }
            return;
        }
        // 尝试1-3位数字
        for(int len = 1; len <= 3 && begin + len <= s.length(); len++){
            String segment = s.substring(begin, begin + len);

            // 检查前导零
            if(segment.length() > 1 && segment.charAt(0) == '0'){
                break;
            }

            // 检查范围
            int num = Integer.parseInt(segment);
            if(num > 255){
                break;
            }

            cur.add(segment);
            dfs(s, begin + len, cur);
            cur.remove(cur.size() - 1);
        }
    }
}