package cn.org.shelly.leetcode.hot100.hard;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * ✔ 滑动窗口最大值
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length - k + 1;
            if(len < 0) return new int[0];
            int [] res = new int[len];
            Deque<Integer> deque = new ArrayDeque<>();
            int l = 0, r = 0;
            int idx = 0;
            while (r < nums.length){
                while (deque.size() > 0 && deque.peekLast() < nums[r]){
                    deque.pollLast();
                }
                deque.add(nums[r]);
                if(r - l + 1 == k){
                    res[idx++] = deque.peekFirst();
                    if(deque.peekFirst() == nums[l]){
                        deque.pollFirst();
                    }
                    l++;
                }
                r++;
            }
            return res;
        }
    }
}
