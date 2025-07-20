package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 回文链表
 * @author shelly
 * @date 2025/7/20
 */
public class Problem_234 {
    class Solution {

        public class ListNode {
            int val;
            Solution.ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public boolean isPalindrome(ListNode head) {
            int newLen = 0;
            ListNode newHead = head;
            while (newHead != null) {
                newLen++;
                newHead = newHead.next;
            }
            newHead = head;
            ListNode p ,tmp;
            for(int i = 1 ;i<=newLen/2;i++){
                newHead = newHead.next;
            }
            p = reverseList(newHead);
            for(int i = 0;i<newLen/2;i++){
                if(head.val != p.val) return false;
                head = head.next;
                p = p.next;
            }
            return true;
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
