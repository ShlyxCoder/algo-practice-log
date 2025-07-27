package cn.org.shelly.leetcode.common.medium;

import java.util.*;
/**
 * ✔ 通过质数传送到达终点的最少跳跃次数
 * @author shelly
 * @date 2025/7/27
 */
public class Problem_460_Q3 {
    class Solution {
        public int minJumps(int[] nums) {
            int n = nums.length;
            if (n == 1) return 0;

            int[] state = new int[n];
            state[0] = 1;

            // 预处理，构建质数 -> 所有能被其整除的下标列表（包括非质数）
            Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // 提取nums[i]的质因数，所有质因数p，加入映射 p -> i
                for (int p : getPrimeFactors(nums[i])) {
                    primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            Set<Integer> usedPrimes = new HashSet<>();
            int steps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int idx = queue.poll();

                    if (idx == n - 1) return steps;

                    // 邻居跳跃
                    for (int next : new int[]{idx - 1, idx + 1}) {
                        if (next >= 0 && next < n && state[next] == 0) {
                            state[next] = 1;
                            queue.offer(next);
                        }
                    }

                    // 质数传送 仅当当前位置值是质数时触发
                    int num = nums[idx];
                    if (isPrime(num) && !usedPrimes.contains(num)) {
                        List<Integer> targets = primeToIndices.getOrDefault(num, Collections.emptyList());
                        for (int j : targets) {
                            if (j != idx && state[j] == 0) {
                                state[j] = 1;
                                queue.offer(j);
                            }
                        }
                        usedPrimes.add(num);
                    }
                }
                steps++;
            }

            return -1;
        }

        // 获取一个数的所有质因数（不改）
        private Set<Integer> getPrimeFactors(int num) {
            Set<Integer> factors = new HashSet<>();
            for (int i = 2; i * i <= num; i++) {
                while (num % i == 0) {
                    factors.add(i);
                    num /= i;
                }
            }
            if (num > 1) factors.add(num);
            return factors;
        }

        // 判断质数（不改）
        private boolean isPrime(int num) {
            if (num <= 1) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}
