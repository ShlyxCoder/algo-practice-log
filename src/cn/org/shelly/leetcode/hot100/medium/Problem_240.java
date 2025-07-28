package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 搜索二维矩阵 II
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                int[] row = matrix[i];
                if (target < row[0]) {
                    return false;
                }
                if (target > row[row.length - 1]) {
                    continue;
                }
                int left = 0, right = row.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (row[mid] == target) {
                        return true;
                    } else if (row[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return false;
        }
    }

}
