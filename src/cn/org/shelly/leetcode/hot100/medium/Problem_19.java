package cn.org.shelly.leetcode.hot100.medium;

import cn.org.shelly.leetcode.hot100.easy.Problem_21;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 删除链表的倒数第N个节点
 * @author shelly
 * @date 2025/7/25
 */
public class Problem_19 {
    class Solution {
        public Problem_21.ListNode removeNthFromEnd(Problem_21.ListNode head, int n) {
            List<Problem_21.ListNode> nodes = new ArrayList<>();
            Problem_21.ListNode curr = head;
            while (curr != null) {
                nodes.add(curr);
                curr = curr.next;
            }
            int idx = nodes.size() - n;
            if (idx == 0) {
                return head.next;
            }
            Problem_21.ListNode prev = nodes.get(idx - 1);
            prev.next = prev.next.next;

            return head;
        }
    }
}
