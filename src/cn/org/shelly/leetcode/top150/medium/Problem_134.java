package cn.org.shelly.leetcode.top150.medium;

public class Problem_134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int [] get = new int[gas.length];
            int sum = 0;
            for(int i = 0;i<gas.length;i++){
                get[i] = gas[i] - cost[i];
                sum += get[i];
            }
            if(sum < 0) return -1;
            sum = 0;
            int start = 0;
            for(int i = 0;i<gas.length;i++){
                sum += get[i];
                if(sum < 0){
                    sum = 0;
                    start = i + 1;
                }
            }
            return start;
        }
    }
}
