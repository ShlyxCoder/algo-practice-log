package cn.org.shelly.leetcode.common.medium;

import java.util.*;

/**
 * 打开转盘锁
 */
public class Problem_752 {
    class Solution {
        public int openLock(String[] deadends, String target) {
            HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
            String original = "0000";
            if(set.contains(original)) return -1;
            set.add(original);
            Deque<String> deque = new ArrayDeque<>();
            deque.offer(original);
            int op = 0;
            int ans = 1000;
            while(!deque.isEmpty()){
                int n = deque.size();
                while(n > 0) {
                    String string = deque.poll();
                    if (target.equals(string)) {
                        ans = Math.min(ans, op);
                        n--;
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(string);
                    for (int i = 0; i < 4; i++) {
                        char c = sb.charAt(i);
                        sb.setCharAt(i, forward(c));
                        String f = sb.toString();
                        if (!set.contains(f)) {
                            set.add(f);
                            deque.offer(f);
                        }
                        sb.setCharAt(i, backend(c));
                        String next = sb.toString();
                        if (!set.contains(next)) {
                            set.add(next);
                            deque.offer(next);
                        }
                        sb.setCharAt(i, c);
                    }
                    n--;
                }
                op++;
            }
            return ans == 1000 ? - 1 : ans;
        }
        private char forward(char c){
            if(c != '9') return (char) (c + 1);
            return '0';
        }
        private char backend(char c){
            if(c != '0') return (char) (c - 1);
            return '9';
        }
    }
}
