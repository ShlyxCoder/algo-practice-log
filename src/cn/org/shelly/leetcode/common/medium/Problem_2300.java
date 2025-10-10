package cn.org.shelly.leetcode.common.medium;

import java.util.Arrays;
/**
 * ✔ 咒语和药水的成功对数
 * @author shelly
 * @date 2025/10/10
 */
public class Problem_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            long need = (success + spells[i] - 1) / spells[i];
            int left = 0, right = m - 1, pos = m;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (potions[mid] >= need) {
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = m - pos;
        }
        return ans;
    }

}
