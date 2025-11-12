package cn.org.shelly.leetcode.design.structure;

public class MyLinkedList<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {}
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Node<K, V> head;
    private final Node<K, V> tail;

    public MyLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public Node<K, V> addFirst(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        insertAfter(head, node);
        return node;
    }

    public void moveToFirst(Node<K, V> node) {
        remove(node);
        insertAfter(head, node);
    }

    public Node<K, V> removeLast() {
        if (tail.prev == head) return null;
        Node<K, V> node = tail.prev;
        remove(node);
        return node;
    }

    public void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAfter(Node<K, V> prevNode, Node<K, V> newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }
}
