package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 搜索二维矩阵
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_74 {
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0, bottom = m - 1;
            while (top <= bottom) {
                int mid = (top + bottom) / 2;
                if (matrix[mid][0] > target) {
                    bottom = mid - 1;
                } else if (matrix[mid][n - 1] < target) {
                    top = mid + 1;
                } else {
                    return binarySearch(matrix[mid], target);
                }
            }
            return false;
        }

        private boolean binarySearch(int[] row, int target) {
            int l = 0, r = row.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (row[mid] == target) return true;
                else if (row[mid] < target) l = mid + 1;
                else r = mid - 1;
            }
            return false;
        }
    }
}
