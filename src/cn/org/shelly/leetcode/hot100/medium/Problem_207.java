package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;
/**
 * ✔ 课程表
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] table = new int[numCourses];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                int goal = prerequisites[i][0];
                int pre = prerequisites[i][1];
                table[goal]++;
                map.computeIfAbsent(pre, k -> new ArrayList<>()).add(goal);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (table[i] == 0) {
                    queue.offer(i);
                }
            }
            int finish = 0;
            while(!queue.isEmpty()){
                Integer course = queue.remove();
                finish++;
                if(map.containsKey(course)){
                    List<Integer> list = map.get(course);
                    for(Integer i : list){
                        table[i] --;
                        if(table[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }
            return finish == numCourses;
        }
    }
}
