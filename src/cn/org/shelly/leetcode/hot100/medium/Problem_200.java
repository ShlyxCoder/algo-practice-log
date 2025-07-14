package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 岛屿数量
 * dfs
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_200 {
    class Solution {
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        int count = 0;

        public void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                dfs(grid, i + x[k], j + y[k]);
            }



        }
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[0].length;j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;
        }
    }
}
