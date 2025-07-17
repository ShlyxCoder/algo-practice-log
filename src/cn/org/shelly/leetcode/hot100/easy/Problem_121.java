package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 买卖股票的最佳时机 I
 * @author shelly
 * @date 2025/7/17
 */
public class Problem_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int max = Integer.MIN_VALUE;
            for(int i = 1;i<prices.length;i++){
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            return Math.max(max, 0);
        }
    }
}
