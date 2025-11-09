package cn.org.shelly.leetcode.top150.medium;

public class Problem_55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int i = 0, len = nums.length - 1;
            while (true) {
                int step = nums[i];
                if (i == len || step >= len - i) return true;
                if (step == 0) break;
                int pre = i, best = -1;
                for (int j = i + 1; j < i + step; j++, best--) {
                    int remain = len - j;
                    if (j == len || nums[j] >= remain) return true;
                    if (nums[j] - step >= best) {
                        i = j;
                        break;
                    }
                }
                if (i == pre) {
                    i += step;
                }
            }
            return false;
        }
    }

}
