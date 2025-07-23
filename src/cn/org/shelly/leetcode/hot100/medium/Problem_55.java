package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 跳跃游戏
 * @author shelly
 * @date 2025/7/23
 */
public class Problem_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        int start = 0, end = 0;
        while (start <= end) {
            int nextEnd = end;
            for (int i = start; i <= end; i++) {
                nextEnd = Math.max(nextEnd, i + nums[i]);
                if (nextEnd >= n - 1) return true;
            }
            if (nextEnd == end) return false;
            start = end + 1;
            end = nextEnd;
        }

        return false;
    }

}
