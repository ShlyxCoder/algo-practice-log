package cn.org.shelly.leetcode.hot100.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * ✔ 合并K个升序链表
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_23 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                curr.next = node;
                curr = curr.next;
                if (node.next != null) {
                    pq.offer(node.next);
                }
            }
            return dummy.next;
        }
    }
}
