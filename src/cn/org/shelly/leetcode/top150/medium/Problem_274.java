package cn.org.shelly.leetcode.top150.medium;

import java.util.Arrays;

public class Problem_274 {
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }
    class Solution_2 {
        public int hIndex(int[] citations) {
            int cnt = 0;
            int len = citations.length;
            int[] arr = new int[1001];
            for (int i = 0; i < len; i++) {
                arr[citations[i]]++;
            }
            for (int i = 1000; i >= 0; i--) {
                cnt += arr[i];
                if (len >= i && cnt >= i)return i;
            }
            return 0;
        }
    }

}
