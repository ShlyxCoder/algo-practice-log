package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 环形链表 II
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_142 {

    public class Solution {

          class ListNode {
              int val;
              ListNode next;
              ListNode(int x) {
                  val = x;
                  next = null;
              }
          }
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }
            if (!hasCycle) return null;
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

    }
}
