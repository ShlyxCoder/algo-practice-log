package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 总价值可以被k整除的岛屿数量
 * @author shelly
 * @date 2025/7/26
 */
public class Problem_161_Q2 {
    class Solution {
        int[][] state;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public int countIslands(int[][] grid, int k) {
            int count = 0;
            int m = grid.length, n = grid[0].length;
            state = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0 && state[i][j] == 0) {
                        int value = dfs(i, j, grid);
                        if (value % k == 0) count++;
                    }
                }
            }

            return count;
        }

        private int dfs(int i, int j, int[][] grid) {
            state[i][j] = 1;
            int sum = grid[i][j];
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length
                        && grid[ni][nj] != 0 && state[ni][nj] == 0) {
                    sum += dfs(ni, nj, grid);
                }
            }
            return sum;
        }
    }

}
