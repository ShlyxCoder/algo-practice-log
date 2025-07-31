package cn.org.shelly.leetcode.design;

public class MyHashMap<K, V> {
    private Node<K, V>[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        size = 0;
        array = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
    }

    public void put(K key, V value) {
        int idx = getHash(key, array.length);
        Node<K, V> head = array[idx];
        if (head == null) {
            array[idx] = new Node<>(key, value);
            size++;
            resizeIfNeeded();
            return;
        }
        Node<K, V> cur = head;
        while (true) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            if (cur.next == null) {
                cur.next = new Node<>(key, value);
                size++;
                resizeIfNeeded();
                return;
            }
            cur = cur.next;
        }
    }

    public V get(K key) {
        int idx = getHash(key, array.length);
        Node<K, V> head = array[idx];
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        int idx = getHash(key, array.length);
        Node<K, V> head = array[idx];
        if (head == null) return;
        if (head.key.equals(key)) {
            array[idx] = head.next;
            size--;
            return;
        }
        Node<K, V> pre = head;
        head = head.next;
        while (head != null) {
            if (head.key.equals(key)) {
                pre.next = head.next;
                size--;
                return;
            }
            head = head.next;
            pre = pre.next;
        }
    }

    public boolean containsKey(K key) {
        int idx = getHash(key, array.length);
        Node<K, V> head = array[idx];
        while (head != null) {
            if (head.key.equals(key)) return true;
            head = head.next;
        }
        return false;
    }

    private int getHash(K key, int len) {
        if (key == null) return 0;
        int h = key.hashCode();
        return (len - 1) & (h ^ (h >>> 16));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        array = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private void resizeIfNeeded() {
        if ((double) size / array.length < LOAD_FACTOR) return;
        Node<K, V>[] newArray = (Node<K, V>[]) new Node[array.length << 1];
        for (Node<K, V> headNode : array) {
            Node<K, V> p = headNode;
            while (p != null) {
                Node<K, V> next = p.next;
                int newIdx = getHash(p.key, newArray.length);
                p.next = newArray[newIdx];
                newArray[newIdx] = p;
                p = next;
            }
        }
        array = newArray;
    }

    public int size() {
        return size;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
