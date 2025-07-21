package cn.org.shelly.leetcode.hot100.easy;

import java.util.HashSet;
import java.util.Set;
/**
 * ✔ 环形链表
 * 遍历
 * @author shelly
 * @date 2025/7/21
 */
public class Problem_141 {
    public class Solution {
        public boolean hasCycle(Problem_21.ListNode head) {
            Set<Problem_21.ListNode> nodes = new HashSet<>();
            while (head != null) {
                if (nodes.contains(head)) return true;
                nodes.add(head);
                head = head.next;
            }
            return false;
        }
    }
}
