package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 螺旋矩阵
 * @author shelly
 * @date 2025/7/17
 */
public class Problem_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            int nums = m * n;
            int k=0,l = 0;
            int i = 0, j = 0;
            while(nums > 0){
                for(;j<n;j++){
                    list.add(matrix[i][j]);
                    nums--;
                    if(nums == 0)  return list;
                }
                j--;
                i++;
                k++;
                for(;i<m;i++){
                    list.add(matrix[i][j]);
                    nums--;
                    if(nums == 0)  return list;
                }
                i--;
                j--;
                n--;
                for(;j>=l;j--){
                    list.add(matrix[i][j]);
                    nums--;
                    if(nums == 0)  return list;
                }
                j++;
                i--;
                m--;
                for(;i>=k;i--){
                    list.add(matrix[i][j]);
                    nums--;
                    if(nums == 0)  return list;
                }
                i++;
                j++;
                l++;
            }
            return list;
        }
    }
}
