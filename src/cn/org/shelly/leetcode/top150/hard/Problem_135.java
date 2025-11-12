package cn.org.shelly.leetcode.top150.hard;

import java.util.Arrays;

public class Problem_135 {
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            Arrays.fill(candies, 1);

            // 从左到右
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }

            // 从右到左
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }

            int sum = 0;
            for (int c : candies) sum += c;
            return sum;
        }
    }

}
