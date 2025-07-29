package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 排序链表
 * @author shelly
 * @date 2025/7/29
 */
public class Problem_148 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null) return null;
            ListNode p = head;
            int len = 1;
            while(p.next != null){
                len++;
                p = p.next;
            }
            return mySort(head,len);
        }

        private ListNode mySort(ListNode head,int len) {
            if(len <= 1) return head;
            int tmpLen = len >> 1;
            ListNode mov = head;
            for(int i = 1; i< tmpLen; i++) mov = mov.next;
            ListNode toR = mov.next;
            mov.next = null;
            ListNode left = mySort(head,tmpLen);
            ListNode right = mySort(toR,  len - tmpLen);
            return mergeTwoLists(left,right);

        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = (l1 != null) ? l1 : l2;

            return dummy.next;
        }
    }
}
