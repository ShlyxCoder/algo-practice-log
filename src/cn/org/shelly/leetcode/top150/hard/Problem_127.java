package cn.org.shelly.leetcode.top150.hard;

import java.util.*;

public class Problem_127 {
    class Solution {
        public int ladderLength(String original, String target, List<String> wordList) {
            HashSet<String> set = new HashSet<>(wordList);
            HashSet<String> visited = new HashSet<>();
            visited.add(original);
            if(!set.contains(target) || original.equals(target)) return 0;
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
                    for (int i = 0; i < wordList.size(); i++) {
                        assert string != null;
                        String next = wordList.get(i);
                        if(convert(string, next) && !visited.contains(next)){
                            deque.offer(next);
                            visited.add(next);
                        }
                    }
                    n--;
                }
                op++;
            }
            return ans == 1000 ? - 1 : ans;
        }
        private boolean convert(String a, String b){
            int diff = 0;
            for(int i = 0;i < a.length(); i++){
                if(a.charAt(i) != b.charAt(i)) diff++;
                if(diff > 1) return false;
            }
            return true;
        }
    }
}
