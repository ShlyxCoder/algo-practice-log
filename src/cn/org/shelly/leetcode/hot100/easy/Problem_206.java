package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 反转链表
 * @author shelly
 * @date 2025/7/20
 */
public class Problem_206 {
    class Solution {

         public class ListNode {
              int val;
              ListNode next;
              ListNode() {}
              ListNode(int val) { this.val = val; }
              ListNode(int val, ListNode next) { this.val = val; this.next = next; }
          }

        public ListNode reverseList(ListNode head) {
            if(head == null) return head;
            ListNode p = head.next;
            ListNode cur = head;
            cur.next = null;
            while(p != null){
                ListNode tmp = p.next;
                p.next = cur;
                cur = p;
                p = tmp;
            }
            return cur;

        }}
}
