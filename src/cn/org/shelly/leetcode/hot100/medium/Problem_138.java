package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 复制带随机指针的链表
 * @author shelly
 * @date 2025/7/29
 */
public class Problem_138 {

    class Solution {

        class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }

        public Node copyRandomList(Node head) {
            List<Integer> list = new ArrayList<>();
            Node p = head;
            Node newHead = new Node(-1);
            Node idx = newHead;
            List<Node> nodes = new ArrayList<>();
            while(p!=null){
                idx.next = new Node(p.val);
                nodes.add(idx.next);
                idx = idx.next;
                Node tmp = p.random;
                int count = 0;
                while(tmp != null){
                    tmp = tmp.next;
                    count ++;
                }
                list.add(count);
                p = p.next;
            }
            idx = newHead.next;
            int i = 0;
            while (idx != null){
                if(list.get(i) != 0) idx.random = nodes.get(nodes.size() - list.get(i));
                idx = idx.next;
                i++;
            }
            return newHead.next;
        }

    }
//    class Solution {
//        Map<Node, Node> cachedNode = new HashMap<Node, Node>();
//
//        public Node copyRandomList(Node head) {
//            if (head == null) {
//                return null;
//            }
//            if (!cachedNode.containsKey(head)) {
//                Node headNew = new Node(head.val);
//                cachedNode.put(head, headNew);
//                headNew.next = copyRandomList(head.next);
//                headNew.random = copyRandomList(head.random);
//            }
//            return cachedNode.get(head);
//        }
//    }
}
