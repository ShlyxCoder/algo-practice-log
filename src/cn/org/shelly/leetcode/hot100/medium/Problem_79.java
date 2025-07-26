package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 单词搜索
 * @author shelly
 * @date 2025/7/26
 */
public class Problem_79 {
    class Solution {
        int[][] state;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        public boolean exist(char[][] board, String word) {
            state = new int[board.length][board[0].length];
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[0].length;j++){
                    if(board[i][j] == word.charAt(0)){
                        state[i][j] = 1;
                        if(dfs(board, 1, word, i , j)) return true;
                        state[i][j] = 0;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int idx, String word,int i, int j) {
            if(idx == word.length())  {
                return true;
            }
            for(int k = 0;k<4;k++){
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length
                        && board[ni][nj] == word.charAt(idx) && state[ni][nj] == 0) {
                    state[ni][nj] = 1;
                    boolean ok = dfs(board, idx +1, word,ni,nj);
                    if(ok) return true;
                    state[ni][nj] = 0;
                }
            }
            return false;
        }
    }
}
