package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;
/**
 * ✔ 找到字符串中华所有字母异位词
 * 滑动窗口
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_438 {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            int num = p.length();
            Map<Character, Integer> m = new HashMap<>();
            for (char c : p.toCharArray()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
            int l = 0,r = 0;
            Map<Character, Integer> tmp = new HashMap<>(m);
            while(r<s.length()){
                char c = s.charAt(r);
                if(!tmp.containsKey(c)){
                    tmp = new HashMap<>(m);
                    num= p.length();
                    r++;
                    l = r;
                }
                else{
                    Integer times = tmp.get(c);
                    if(times > 0){
                        num--;
                        tmp.put(c,times-1);
                    }
                    else{
                        while(true){
                            char front = s.charAt(l);
                            l++;
                            if(front == c){
                                break;
                            }
                            tmp.put(front,tmp.getOrDefault(front, 0) + 1);
                            num++;
                        }
                    }
                    if(num == 0){
                        list.add(r - p.length() + 1);
                        num ++;
                        char front = s.charAt(l);
                        tmp.put(front,tmp.getOrDefault(front, 0) + 1);
                        l++;
                    }
                    r++;
                }

            }
            return list;
        }
    }
}
