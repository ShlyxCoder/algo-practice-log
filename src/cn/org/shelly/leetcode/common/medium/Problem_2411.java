package cn.org.shelly.leetcode.common.medium;


/**
 * ？ 按位或最大的最小子数组长度
 * @author shelly
 * @date 2025/7/29
 */
public class Problem_2411 {
    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int[] last = new int[32];
            for (int i = 0; i < 32; i++) {
                last[i] = -1;
            }
            // 从后往前遍历，记录每一位为 1 的“最近出现位置”。
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < 32; j++) {
                    if (((nums[i] >> j) & 1) == 1) {
                        last[j] = i;
                    }
                }
                int farthest = i;
                // 注意，为什么不考虑是不是自己的1，因为从右往左，如果是自己的1，那么就是最小的，不会产生干扰
                for (int j = 0; j < 32; j++) {
                    if (last[j] != -1) {
                        //但凡是1，都要取，因为如果自己有，那么last[j] = i = 自己，max下不会影响，而一旦没有
                        //，更要考虑max，因为后面的1位次不一定比前面高，如果用min，可能损失
                        farthest = Math.max(farthest, last[j]);
                    }
                }
                res[i] = farthest - i + 1;
            }
            return res;
        }
    }

}
/**
 * 按位或运算是单调增加的
 */
