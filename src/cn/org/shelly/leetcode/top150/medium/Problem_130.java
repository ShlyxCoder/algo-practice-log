package cn.org.shelly.leetcode.top150.medium;

public class Problem_130 {
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) return;
            int m = board.length, n = board[0].length;

            // 1. 从边界出发，把所有与边界相连的 'O' 标记为 '#'
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0);
                dfs(board, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(board, 0, j);
                dfs(board, m - 1, j);
            }

            // 2. 遍历全图，做最终替换
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            int m = board.length, n = board[0].length;
            if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;

            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }

}
