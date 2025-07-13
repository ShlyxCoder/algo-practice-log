package cn.org.shelly.leetcode.hot100.medium;

import java.util.*;

/**
 * ✔ 字母异位词分组
 * @author shelly
 * @date 2025/7/13
 */
public class Problem_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)){
                List<String> list = map.get(sorted);
                list.add(s);
                map.put(sorted,list);
                continue;
            }
            map.put(sorted, new ArrayList<>(List.of(s)));
        }
        return new ArrayList<>(map.values());
    }
}
