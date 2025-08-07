package cn.org.shelly.leetcode.hot100.hard;

import java.util.Stack;
/**
 * ✔ 接雨水
 * @author shelly
 * @date 2025/8/7
 */
public class Problem_42 {
    class Solution {
        public int trap(int[] height) {
            int ret = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < height.length; i++) {
                // 当前柱子比栈顶高，说明可以形成凹槽
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int bottom = stack.pop();
                    if (stack.isEmpty()) break;
                    int left = stack.peek(); // 左边界
                    int width = i - left - 1; // 宽度
                    int minHeight = Math.min(height[i], height[left]) - height[bottom]; // 高度差

                    ret += width * minHeight;
                }
                stack.push(i); // 当前柱子入栈
            }

            return ret;
        }
    }

}
/**
 * 每次不只是比较两个台阶，其实是比较三个台阶哦
 */