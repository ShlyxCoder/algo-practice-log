package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 插入一个字母的最大序列数
 * @author shelly
 * @date 2025/7/27
 */
public class Problem_460_Q2 {
        class Solution {
            public long numOfSubsequences(String s) {
                int n = s.length();
                if (n < 2) return 0;

                int[] l = new int[n + 1];
                int[] t = new int[n + 1];

                for (int i = 0; i < n; i++) {
                    l[i + 1] = l[i] + (s.charAt(i) == 'L' ? 1 : 0);
                }


                for (int i = n - 1; i >= 0; i--) {
                    t[i] = t[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
                }

                long ret = 0;
                long ret_l = 0;
                long ret_t = 0;

                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == 'C') {
                        ret += (long) l[j] * t[j + 1];
                        ret_l += (long) (l[j] + 1) * t[j + 1];
                        ret_t += (long) l[j] * (t[j + 1] + 1);
                    }
                }

                long ret_c = 0;
                for (int i = 0; i <= n; i++) {
                    ret_c = Math.max(ret_c, (long) l[i] * t[i]);
                }

                return Math.max(Math.max(ret_l, ret_t), ret + ret_c);
            }
        }


        public static void main(String[] args) {
        Solution s = new Problem_460_Q2().new Solution();
        System.out.println(s.numOfSubsequences("TLVTCCTL"));
    }
}
