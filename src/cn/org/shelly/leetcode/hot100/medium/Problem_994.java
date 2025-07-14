package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 腐烂的橘子
 * 模拟
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_994 {
    class Solution {
        class Pair{
            int x;
            int y;
            Pair(int a, int b){
                x = a;
                y = b;
            }
        }
        public int orangesRotting(int[][] grid) {
            int oranges = 0;
            List<Pair> list = new ArrayList<>();
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[0].length;j++){
                    if(grid[i][j] == 2){
                        list.add(new Pair(i,j));
                    }
                    if(grid[i][j] == 1){
                        oranges++;
                    }
                }
            }
            int time = 0;
            int[] x_mov = new int[]{1,0,0,-1};
            int[] y_mov = new int[]{0,1,-1,0};
            while(oranges > 0){
                time++;
                boolean find = false;
                List<Pair> next = new ArrayList<>();
                for(int i = 0;i< list.size();i++){
                    int x = list.get(i).x;
                    int y = list.get(i).y;
                    for(int j = 0;j<4;j++){
                        int cur_x = x+x_mov[j];
                        int cur_y = y+y_mov[j];
                        if(cur_y >=0 && cur_y < grid.length && cur_x>=0 && cur_x<grid[0].length){
                            if(grid[cur_x][cur_y] == 1){
                                oranges--;
                                grid[cur_x][cur_y] = 2;
                                next.add(new Pair(cur_x,cur_y));
                                find = true;
                            }
                        }
                    }
                }
                list = next;
                if(!find){
                    break;
                }
            }
            if(oranges > 0){
                return -1;
            }
            return  time;
        }
    }
}
