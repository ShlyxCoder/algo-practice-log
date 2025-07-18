package cn.org.shelly.leetcode.common.hard;

import java.util.Collections;
import java.util.PriorityQueue;
/**
 * ✔ 删除元素后和的最小差值
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_2163 {

    class Solution {
        public long minimumDifference(int[] nums) {
            int n = nums.length / 3;
            int len = nums.length;

            long[] left = new long[len];
            long[] right = new long[len];

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            long sum = 0;
            for (int i = 0; i < 2 * n; i++) {
                sum += nums[i];
                maxHeap.offer(nums[i]);
                if (maxHeap.size() > n) {
                    sum -= maxHeap.poll();
                }
                if (maxHeap.size() == n) {
                    left[i] = sum;
                }
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            sum = 0;
            for (int i = len - 1; i >= n; i--) {
                sum += nums[i];
                minHeap.offer(nums[i]);
                if (minHeap.size() > n) {
                    sum -= minHeap.poll();
                }
                if (minHeap.size() == n) {
                    right[i] = sum;
                }
            }

            long res = Long.MAX_VALUE;
            for (int i = n - 1; i < 2 * n; i++) {
                res = Math.min(res, left[i] - right[i + 1]);
            }
            return res;
        }
    }

}
/**
 * 护一个「前 2n」中的 n 个最小值和（大根堆）
 * 维护一个「后 2n」中的 n 个最大值和（小根堆）
 * 分别存到 left[] 和 right[] 中
 * 最后找一个使得 left[i] - right[i+1] 最小的位置
 * 因为中间的分割只能在n-2n，所以left，right相当于是枚举到指定位置
 */
