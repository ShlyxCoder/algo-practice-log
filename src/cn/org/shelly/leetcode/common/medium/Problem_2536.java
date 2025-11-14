package cn.org.shelly.leetcode.common.medium;

/**
 * √ 子矩阵元素加1
 */
public class Problem_2536 {
    class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int [][] ret = new int[n][n];
            int [][] dif = new int[n + 1][n + 1];
            // 构造差分矩阵
            for(int[] q : queries){
                int x1 = q[0], y1 = q[1], x2 = q[2], y2 = q[3];
                dif[x1][y1] += 1;
                dif[x1][y2+1] -= 1;
                dif[x2+1][y1] -= 1;
                dif[x2+1][y2+1] += 1;
            }

            // 还原原矩阵
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    ret[i][j] = dif[i][j] + getVal(i-1,j,ret,n) + getVal(i,j-1,ret,n) - getVal(i-1,j-1,ret,n);
                }
            }

            return ret;
        }
        public int getVal(int i , int j , int [][] arr, int n){
            if(i < 0 || i > n || j < 0 || j > n) return 0;
            return arr[i][j];
        }
    }
}
