package cn.org.shelly.leetcode.top150.medium;

import java.util.*;

public class Problem_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] indegree = new int[numCourses];
            List<Integer>[] graph = new ArrayList[numCourses];
            int [] ret = new int[numCourses];
            int idx = 0;
            // 建图 + 入度
            for (int[] p : prerequisites) {
                int goal = p[0];
                int pre  = p[1];
                indegree[goal] += 1;

                if (graph[pre] == null)
                    graph[pre] = new ArrayList<>();
                graph[pre].add(goal);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) queue.add(i);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                ret[idx++] = cur;
                List<Integer> list = graph[cur];
                if (list == null) continue;

                for (int i = 0; i < list.size(); i++) {
                    int next = list.get(i);
                    if (--indegree[next] == 0) queue.add(next);
                }
            }
            if(count == numCourses){
                return ret;
            }
            return new int[]{};
        }
    }
}
