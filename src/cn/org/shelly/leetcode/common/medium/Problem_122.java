package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 买卖股票的最佳时机 II
 * @author shelly
 * @date 2025/9/15
 */
public class Problem_122 {
    class Solution {
        public int maxProfit(int[] prices) {
            int a = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i]>prices[i-1]){
                    a+= (prices[i]-prices[i-1]);
                }
            }
            return a;
        }
    }
}
