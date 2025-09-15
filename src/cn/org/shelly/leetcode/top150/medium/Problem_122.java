package cn.org.shelly.leetcode.top150.medium;

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
