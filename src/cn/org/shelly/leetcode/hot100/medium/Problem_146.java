package cn.org.shelly.leetcode.hot100.medium;

import java.util.HashMap;
import java.util.Map;
/**
 * ✔ LRU缓存
 * linkedList 源码
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_146 {
    class LRUCache {
        int size;
        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;
            public LinkedNode() {}
            public LinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        Map<Integer, LinkedNode> map = new HashMap<>();
        private LinkedNode head, tail;
        public LRUCache(int capacity) {
            size = capacity;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            LinkedNode num = map.getOrDefault(key,null);
            if(num == null) return -1;
            modifyToMostUsed(num);
            return num.value;
        }

        public void put(int key, int value) {
            LinkedNode num = map.getOrDefault(key,null);
            if(num != null){
                num.value = value;
                modifyToMostUsed(num);
                return;
            }
            LinkedNode node = new LinkedNode(key,value);
            node.value = value;
            if(map.size() + 1 > size) {
                remove();
            }
            map.put(key, node);
            insert(node);
        }
        void modifyToMostUsed(LinkedNode num){
            num.prev.next = num.next;
            num.next.prev = num.prev;
            num.next = head.next;
            head.next.prev = num;
            num.prev = head;
            head.next = num;
        }
        void insert(LinkedNode node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
        void remove(){
            LinkedNode l = tail.prev;
            if(l == head) return;
            map.remove(l.key);
            l = l.prev;
            l.next = tail;
            tail.prev = l;
        }
    }

}
