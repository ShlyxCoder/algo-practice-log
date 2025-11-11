package cn.org.shelly.leetcode.top150.medium;

public class Problem_45 {
    class Solution {
        public int jump(int[] nums) {
            int ans = 0;
            int now = 0;
            int n = nums.length;
            while (now < n) {
                if (now == n - 1) return ans;
                int next = now + nums[now];
                if (next >= n - 1) return ans + 1;
                int exp = next + nums[next];
                int l = now + 1, r = next;
                for (int i = l; i <= r; i++) {
                    int reach = i + nums[i];
                    if (reach >= exp) {
                        exp = reach;
                        next = i;
                    }
                }
                ans++;
                now = next;
            }
            return ans;
        }
    }

}
