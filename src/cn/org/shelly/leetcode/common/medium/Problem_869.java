package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ✔ 重新排序得到 2 的幂
 * @author shelly
 * @date 2025/8/10
 */
public class Problem_869 {
    class Solution {
        public boolean reorderedPowerOf2(int n) {
            StringBuilder sb = new StringBuilder();
            int zeros = fuc(n, sb);
            int value = Integer.parseInt(sb.toString());
            int times = 0;
            while (true){
                int cur = (int) Math.pow(2, times);
                if(cur > Math.pow(10,9)) break;
                if(cur >= value){
                    StringBuilder sb2 = new StringBuilder();
                    int z = fuc(cur, sb2);
                    if((sb2.compareTo(sb) == 0) && zeros == z) return true;
                }
                times++;
            }
            return false;
        }

        private int fuc(int n, StringBuilder out) {
            List<Integer> digits = new ArrayList<>();
            int zeroCount = 0;
            while (n > 0) {
                int tmp = n % 10;
                if (tmp == 0) {
                    zeroCount++;
                } else {
                    digits.add(tmp);
                }
                n /= 10;
            }
            Collections.sort(digits);
            for (int d : digits) {
                out.append(d);
            }
            return zeroCount;
        }

    }
}
