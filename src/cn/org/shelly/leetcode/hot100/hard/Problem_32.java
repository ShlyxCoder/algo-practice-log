package cn.org.shelly.leetcode.hot100.hard;

import java.util.Arrays;

/**
 * ✔ 最长有效括号
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_32 {
    class Solution {
        public int longestValidParentheses(String s) {
            if(s.isEmpty()) return 0;
            int [] dp = new int[s.length()];
            Arrays.fill(dp, 0);
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == '(' || i == 0) dp[i] = 0;
                else{
                    if(s.charAt(i-1) == '('){
                        if(i-2>=0) dp[i] = dp[i-2] + 1;
                        else{
                            dp[i] = 1;
                        }
                    }
                    else{
                        if(dp[i-1] > 0 && i-1-2*dp[i-1] >= 0 && s.charAt(i-1-2*dp[i-1]) == '('){
                            if(i-2-2*dp[i-1]>=0) dp[i] = dp[i-1] + 1 + dp[i-2-2*dp[i-1]];
                            else dp[i] = dp[i-1] + 1;
                        }
                    }
                }
            }
            int max = -1;
            for(int i = 0;i<s.length();i++){
                max = Math.max(max, dp[i]);
            }
            return max * 2;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Problem_32().new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
}

