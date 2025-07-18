package cn.org.shelly.leetcode.hot100.medium;

import java.util.PriorityQueue;

/**
 * ✔ 数组中的第K个最大元素
 * @author shelly
 * @date 2025/7/16
 */
public class Problem_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            return heap.peek();
        }
    }
}
