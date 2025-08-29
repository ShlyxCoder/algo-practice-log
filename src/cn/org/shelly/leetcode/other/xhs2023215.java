package cn.org.shelly.leetcode.other;

import java.util.Scanner;

public class xhs2023215 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int T = sc.nextInt();
            int H = sc.nextInt();

            int[] t = new int[n];
            int[] h = new int[n];
            long[] a = new long[n];

            for(int i = 0; i < n; i++){
                t[i] = sc.nextInt();
                h[i] = sc.nextInt();
                a[i] = sc.nextLong();
            }

            long[][] dp = new long[T + 1][H + 1];

            for(int k = 0; k < n; k++){
                for(int i = T; i >= t[k]; i--){
                    for(int j = H; j >= h[k]; j--){
                        dp[i][j] = Math.max(dp[i][j], dp[i - t[k]][j - h[k]] + a[k]);
                    }
                }
            }

            System.out.println(dp[T][H]);
        }
}
