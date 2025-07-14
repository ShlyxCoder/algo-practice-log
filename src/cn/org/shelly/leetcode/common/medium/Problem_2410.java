package cn.org.shelly.leetcode.common.medium;

import java.util.PriorityQueue;
/**
 * ✔ 运动员和训练师的最大匹配数
 * 优先队列
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_2410 {
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            int ret = 0;
            PriorityQueue<Integer> p = new PriorityQueue<>();
            PriorityQueue<Integer> t = new PriorityQueue<>();
            for(int i = 0;i<players.length;i++){
                p.add(players[i]);
            }
            for(int i = 0;i<trainers.length;i++){
                t.add(trainers[i]);
            }
            while (!t.isEmpty() && !p.isEmpty()){
                int tmp = p.peek();
                if(t.peek() >= tmp){
                    ret++;
                    t.poll();
                    p.poll();
                }
                else{
                    t.poll();
                }
            }
            return ret;
        }
    }
}
