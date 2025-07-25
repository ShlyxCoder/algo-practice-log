package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 两两交换链表中的节点
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_24 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode a = head, b = head.next;
            int time = 1;
            while(true){
                ListNode p = b.next;
                a.next = p;
                if(p!= null &&p.next != null) a.next = p.next;
                b.next = a;
                if(time ==1) head = b;
                time--;
                a = p;
                if(a == null) break;
                b = a.next;
                if(b == null) break;
            }
            return head;
        }
    }
}
