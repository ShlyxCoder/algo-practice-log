package cn.org.shelly.leetcode.common.hard;

import java.util.*;

/**
 * 单词接龙II
 */
public class Problem_126 {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            List<List<String>> res = new ArrayList<>();
            if (!dict.contains(endWord)) return res;

            // BFS 队列
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            // 前驱 map
            Map<String, List<String>> prevMap = new HashMap<>();
            prevMap.put(beginWord, new ArrayList<>());

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            boolean found = false;

            while (!queue.isEmpty() && !found) {
                int size = queue.size();
                Set<String> thisLevelVisited = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    char[] arr = word.toCharArray();
                    for (int j = 0; j < arr.length; j++) {
                        char old = arr[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == old) continue;
                            arr[j] = c;
                            String next = new String(arr);
                            if (!dict.contains(next)) continue;
                            if (!prevMap.containsKey(next)) prevMap.put(next, new ArrayList<>());
                            if (!visited.contains(next)) {
                                prevMap.get(next).add(word);
                                if (!thisLevelVisited.contains(next)) {
                                    queue.offer(next);
                                    thisLevelVisited.add(next);
                                }
                            } else if (thisLevelVisited.contains(next)) {
                                // 本层可以有多个前驱
                                prevMap.get(next).add(word);
                            }

                            if (next.equals(endWord)) found = true;
                        }
                        arr[j] = old;
                    }
                }
                visited.addAll(thisLevelVisited);
            }

            if (!prevMap.containsKey(endWord)) return res;

            // DFS 回溯所有路径
            LinkedList<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(prevMap, path, beginWord, endWord, res);
            return res;
        }

        private void dfs(Map<String, List<String>> prevMap, LinkedList<String> path,
                         String beginWord, String cur, List<List<String>> res) {
            if (cur.equals(beginWord)) {
                List<String> tmp = new ArrayList<>(path);
                Collections.reverse(tmp);
                res.add(tmp);
                return;
            }
            for (String prev : prevMap.get(cur)) {
                path.add(prev);
                dfs(prevMap, path, beginWord, prev, res);
                path.removeLast();
            }
        }
    }

}
