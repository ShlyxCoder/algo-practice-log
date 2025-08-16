package cn.org.shelly.leetcode.hot100.hard;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ N皇后
 * @author shelly
 * @date 2025/8/16
 */
public class Problem_51 {
    class Solution {
        int [] [] visited;
        int [] l;
        List<List<String>> list = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            visited = new int[n][n];
            l = new int[n];
            dfs(0,n);
            return list;
        }

        private void dfs(int i, int n) {
            if(i == n){
                List<String> cur = new ArrayList<>();
                for(int j = 0;j<n;j++){
                    StringBuilder s = new StringBuilder();
                    for(int k = 0;k<n;k++){
                        char c = visited[j][k] == 1 ? 'Q' : '.';
                        s.append(c);
                    }
                    cur.add(s.toString());
                }
                list.add(cur);
                return;
            }
            for(int idx = 0;idx<n;idx++){
                if(l[idx] == 0 && check(i,idx,n)){
                    visited[i][idx] = 1;
                    l[idx] = 1;
                    dfs(i+1,n);
                    l[idx] = 0;
                    visited[i][idx] = 0;
                }
            }

        }
        boolean check(int i, int j, int n) {
            for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
                if (visited[x][y] == 1) return false;
            }
            for (int x = i - 1, y = j + 1; x >= 0 && y < n; x--, y++) {
                if (visited[x][y] == 1) return false;
            }
            return true;
        }
    }
}
