package cn.org.shelly.leetcode.common.easy;

/**
 * ✔* 设计哈希映射
 * @author shelly
 * @date 2025/7/30
 */
public class Problem_706 {
    class MyHashMap {
        private Node[] array = new Node[16];
        private int size;

        public MyHashMap() {
            size = 0;
        }

        public void put(int key, int value) {
            int idx = getHash(key, array.length);
            Node head = array[idx];
            if(head == null) {
                array[idx] = new Node(key,value);
                size++;
                resizeIfNeeded();
                return;
            }
            while(true){
                if(head.key == key){
                    head.value = value;
                    return;
                }
                if(head.next == null){
                    head.next = new Node(key,value);
                    size++;
                    resizeIfNeeded();
                    return;
                }
                head = head.next;
            }

        }

        public int get(int key) {
            int idx = getHash(key,array.length);
            Node head = array[idx];
            while(head != null){
                if(head.key == key) return head.value;
                head = head.next;
            }
            return -1;
        }

        public void remove(int key) {
            int idx = getHash(key, array.length);
            Node head = array[idx];
            if (head == null) return;
            if(head.key == key) {
                array[idx] = head.next;
                size--;
                return;
            }
            Node pre = head;
            head = head.next;
            while(head != null){
                if(head.key == key) {
                    pre.next = head.next;
                    size--;
                    return;
                }
                head = head.next;
                pre = pre.next;
            }
        }
        public boolean containsKey(int key){
            int idx = getHash(key, array.length);
            Node head = array[idx];
            while(head != null){
                if(head.key == key) return true;
                head = head.next;
            }
            return false;
        }
        public int getHash(int key, int len) {
            return (len - 1) & Math.abs(key);
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void clear(){
            array = new Node[16];
            size = 0;
        }
        private void resizeIfNeeded() {
            if ((double) size / array.length < 0.75) return;
            Node[] newArray = new Node[array.length << 1];
            for (Node headNode : array) {
                Node p = headNode;
                while (p != null) {
                    Node next = p.next;
                    int newIdx = getHash(p.key, newArray.length);
                    p.next = newArray[newIdx];
                    newArray[newIdx] = p;
                    p = next;
                }
            }
            array = newArray;
        }

        public int size(){
            return size;
        }
        class Node {
            int key;
            int value;
            Node next;
            Node(int key,int value){
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }
    }

}
