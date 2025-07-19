package cn.org.shelly.leetcode.common.medium;

import java.util.*;
/**
 * ✔ 删除子文件夹
 * @author shelly
 * @date 2025/7/19
 */
public class Problem_1233 {

    class Solution {
        class Struct {
            String c;
            Map<String, Struct> map = new HashMap<>();
            boolean isEnd = false;
            Struct(String tmp) {
                c = tmp;
            }
        }

        List<String> list = new ArrayList<>();

        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder);
            Struct struct = new Struct(null);
            for (int i = 0; i < folder.length; i++) {
                String[] s = folder[i].split("/");
                boolean isOk = fill(struct, 1, s);
                if (isOk) list.add(folder[i]);
            }
            return list;
        }

        boolean fill(Struct struct, int pos, String[] s) {
            if (struct.isEnd) return false;
            if (pos == s.length) {
                struct.isEnd = true;
                return true;
            }

            Map<String, Struct> map = struct.map;
            if (!map.containsKey(s[pos])) {
                map.put(s[pos], new Struct(s[pos]));
            }

            return fill(map.get(s[pos]), pos + 1, s);
        }
    }
}
