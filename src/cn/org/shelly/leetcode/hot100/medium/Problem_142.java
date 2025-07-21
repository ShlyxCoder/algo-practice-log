package cn.org.shelly.leetcode.hot100.medium;

import cn.org.shelly.leetcode.hot100.easy.Problem_21;

import java.util.HashSet;
import java.util.Set;
/**
 * ✔ 环形链表 II
 * 遍历
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_142 {
    public class Solution {
        public Problem_21.ListNode detectCycle(Problem_21.ListNode head) {
            Set<Problem_21.ListNode> nodes = new HashSet<>();
            while (head != null) {
                if (nodes.contains(head)) return head;
                nodes.add(head);
                head = head.next;
            }
            return null;
        }
    }
}
