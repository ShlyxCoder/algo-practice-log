package cn.org.shelly.leetcode.top150.easy;

import java.util.Random;

public class Problem_169 {
    class Solution {
        private int randRange(Random rand, int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private int countOccurences(int[] nums, int num) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        public int majorityElement(int[] nums) {
            Random rand = new Random();

            int majorityCount = nums.length / 2;

            while (true) {
                int candidate = nums[randRange(rand, 0, nums.length)];
                if (countOccurences(nums, candidate) > majorityCount) {
                    return candidate;
                }
            }
        }
    }
}
