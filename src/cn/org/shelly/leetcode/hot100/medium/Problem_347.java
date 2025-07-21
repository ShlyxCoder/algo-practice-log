package cn.org.shelly.leetcode.hot100.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * ✔ 前k个高频元素
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_347 {

    public class Solution {
        class Pair {
            int key;
            int count;

            public Pair(int key, int count) {
                this.key = key;
                this.count = count;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.count));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll().key;
            }
            return result;
        }
    }

}
