package cn.org.shelly.leetcode.hot100.hard;
/**
 * ？ k个一组翻转链表
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_25 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prevGroupEnd = dummy;
            ListNode p = head;

            while (true) {
                ListNode groupStart = p;
                int count = 0;
                while (p != null && count < k) {
                    p = p.next;
                    count++;
                }
                if (count < k) break;

                // 断开当前这组节点
                ListNode nextGroupStart = p; // 第 k+1 个节点
                p = groupStart;
                for (int i = 0; i < k; i++) {
                    ListNode tmp = p.next;
                    p.next = nextGroupStart;
                    nextGroupStart = p;
                    p = tmp;
                }

                // 连接反转后的子链表
                prevGroupEnd.next = nextGroupStart; // nextGroupStart 此时是反转后的新头
                prevGroupEnd = groupStart;          // 原来的头变成现在的尾，准备连接下一组
            }

            return dummy.next;
        }

    }
}
