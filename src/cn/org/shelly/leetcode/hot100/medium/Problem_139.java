package cn.org.shelly.leetcode.hot100.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * ✔ 单词拆分
 * @author shelly
 * @date 2025/7/22
 */
public class Problem_139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>();
            set.addAll(wordDict);
            boolean [] dp = new boolean[s.length() + 1];
            Arrays.fill(dp, false);
            for(int i = 0;i<s.length();i++){
                if(wordDict.contains(s.substring(0, i+1))) {
                    dp[i] = true;
                    continue;
                }
                for(int j = 0;j< i;j++){
                    if(dp[j] && wordDict.contains(s.substring(j+1,i+1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()-1];
        }
    }
}
