package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ✔ 实现 Trie (前缀树)
 * @author shelly
 * @date 2025/7/28
 */
public class Problem_208 {
    class Trie {
        //可以更优化成数组
        Map<Character, Trie> map = new HashMap<>();
        boolean isEnd = false;

        public Trie() {}

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                node.map.putIfAbsent(c, new Trie());
                node = node.map.get(c);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                node = node.map.get(c);
                if (node == null) return false;
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (char c : prefix.toCharArray()) {
                node = node.map.get(c);
                if (node == null) return false;
            }
            return true;
        }
    }
/**
 * 递归版本，性能低下
 */
//    class Trie {
//        Map<Character , Trie> map = new HashMap<>();
//        boolean isEnd = false;
//
//        public Trie() {
//
//        }
//
//        public void insert(String word) {
//            Trie trie = map.getOrDefault(word.charAt(0), null);
//            if(trie == null){
//                trie = new Trie();
//                map.put(word.charAt(0), trie);
//            }
//            if(0 == word.length() -1) {
//                trie.isEnd = true;
//                return;
//            }
//            trie.insert(word.substring(1));
//        }
//
//        public boolean search(String word) {
//            if(word.isEmpty()) return true;
//            Trie trie = map.getOrDefault(word.charAt(0), null);
//            if(trie == null) return false;
//            if(0 == word.length() -1) {
//                return trie.isEnd;
//            }
//            return trie.search(word.substring(1));
//        }
//
//        public boolean startsWith(String prefix) {
//            if(prefix.isEmpty()) return true;
//            Trie trie = map.getOrDefault(prefix.charAt(0), null);
//            if(trie == null) return false;
//            return trie.startsWith(prefix.substring(1));
//        }
//    }
}
