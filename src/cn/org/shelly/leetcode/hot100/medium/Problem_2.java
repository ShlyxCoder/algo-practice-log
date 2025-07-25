package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 两数相加
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_2 {
    class Solution {

          public class ListNode {
              int val;
              ListNode next;
              ListNode() {}
              ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
          }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
              ListNode head = new ListNode();
              ListNode p = head;
              int toNext = 0;
              while(l1 != null && l2 != null){
                  int val = toNext + l1.val + l2.val;
                  ListNode node = new ListNode(val%10);
                  toNext = val/10;
                  p.next = node;
                  p = node;
                  l1 = l1.next;
                  l2 = l2.next;
              }
              while(l1!=null){
                  int val = toNext + l1.val ;
                  ListNode node = new ListNode(val%10);
                  toNext = val/10;
                  p.next = node;
                  p = node;
                  l1 = l1.next;
              }
              while (l2!=null){
                  int val = toNext+ l2.val;
                  ListNode node = new ListNode(val%10);
                  toNext = val/10;
                  p.next = node;
                  p = node;
                  l2 = l2.next;
              }
              if(toNext != 0) {
                  p.next = new ListNode(toNext);
              }
              return head.next;
        }
    }
}
