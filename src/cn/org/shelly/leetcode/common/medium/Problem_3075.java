package cn.org.shelly.leetcode.common.medium;

import java.util.Arrays;

public class Problem_3075 {
    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            Arrays.sort(happiness);
            long sum = 0;
            int sub = 0;
            for(int i = happiness.length - 1;i>=0 && k > 0;i--){
                int cur = happiness[i] - sub;
                if(cur <= 0) return sum;
                sum += cur;
                sub++;
                k--;
            }
            return sum;
        }
    }
}
