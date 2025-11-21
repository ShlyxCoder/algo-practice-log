package cn.org.shelly.leetcode.top150.medium;

import java.util.*;

public class Problem_433 {
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {

            char[] genes = {'A', 'C', 'G', 'T'};

            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            if (!bankSet.contains(endGene)) return -1;

            Queue<String> queue = new LinkedList<>();
            queue.offer(startGene);

            Set<String> visited = new HashSet<>();
            visited.add(startGene);

            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    String cur = queue.poll();
                    if (cur.equals(endGene)) return step;
                    char[] arr = cur.toCharArray();
                    for (int i = 0; i < 8; i++) {
                        char old = arr[i];
                        for (char g : genes) {
                            if (g == old) continue;
                            arr[i] = g;
                            String next = new String(arr);
                            if (bankSet.contains(next) && !visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                        }

                        arr[i] = old;
                    }
                }
                step++;
            }

            return -1;
        }
    }

}
