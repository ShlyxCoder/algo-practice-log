package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashSet;
import java.util.Set;
/**
 * ✔ 乘最多水的容器无重复字符的最长子串
 * 滑动窗口
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_3 {
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int l=0,r=0;
            int max = 0;
            while (r<s.length()){
                if(set.isEmpty()){
                    set.add(s.charAt(r));
                    r++;
                    max = Math.max(set.size(),max);
                    continue;
                }
                if(set.contains(s.charAt(r))){
                    while(true){
                       char c = s.charAt(l);
                       set.remove(c);
                       l++;
                       if(c == s.charAt(r)){
                           break;
                       }
                    }
                }
                set.add(s.charAt(r));
                max = Math.max(set.size(),max);
                r++;
            }
            return Math.max(max,r-l);
        }
    }
}
