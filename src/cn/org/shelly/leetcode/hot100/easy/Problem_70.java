package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 爬楼梯
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_70 {
    class Solution {
        public int climbStairs(int n) {
            if(n < 2) return 1;
            int [] arr = new int[n + 1];
            arr[0]  = 0;
            arr[1] = 1;
            arr[2] = 2;
            for(int i = 3;i<n+1 ;i++) arr[i] = arr[i-1] + arr[i-2];
            return arr[n];

        }
    }
}
