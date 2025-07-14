package cn.org.shelly.leetcode.common.hard;

import java.util.*;

/**
 * ✔ 最佳运动员的比拼回合
 * 模拟
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_1900 {

    public class Solution {
        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            Random random = new Random();

            for (int t = 0; t < 800; t++) {
                List<Integer> list = new ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    list.add(i);
                }

                int times = 1;
                while (true) {
                    boolean isOut = false;
                    List<Integer> next = new ArrayList<>();

                    for (int j = 0; j < list.size() / 2; j++) {
                        int left = list.get(j);
                        int right = list.get(list.size() - 1 - j);

                        if ((left == firstPlayer && right == secondPlayer) ||
                                (left == secondPlayer && right == firstPlayer)) {
                            isOut = true;
                            break;
                        }

                        if (left == firstPlayer || left == secondPlayer) {
                            next.add(left);
                        } else if (right == firstPlayer || right == secondPlayer) {
                            next.add(right);
                        } else {
                            next.add(random.nextBoolean() ? left : right);
                        }
                    }

                    if (list.size() % 2 == 1) {
                        next.add(list.get(list.size() / 2));
                    }

                    if (isOut) {
                        min = Math.min(min, times);
                        max = Math.max(max, times);
                        break;
                    }
                    Collections.sort(next);
                    list = next;
                    times++;
                }
            }

            return new int[]{min, max};
        }
    }

}

