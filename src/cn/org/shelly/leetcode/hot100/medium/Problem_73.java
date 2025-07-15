package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashSet;
import java.util.Set;
/**
 * ✔ 矩阵置0
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> hang = new HashSet<>();
            Set<Integer> lie = new HashSet<>();
            for(int i = 0;i<matrix.length;i++){
                for(int j = 0;j<matrix[i].length;j++){
                    if(matrix[i][j] == 0){
                        hang.add(i);
                        lie.add(j);
                    }
                }
            }
            for(Integer c : hang){
                for(int i = 0;i<matrix[0].length;i++){
                    matrix[c][i] = 0;
                }
            }
            for(Integer c : lie){
                for(int i = 0;i<matrix.length;i++){
                    matrix[i][c] = 0;
                }
            }
        }
    }
}
