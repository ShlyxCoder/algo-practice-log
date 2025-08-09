package cn.org.shelly.leetcode.common.easy;
/**
 * ✔ 2的幂
 * @author shelly
 * @date 2025/8/9
 */
public class Problem_231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
