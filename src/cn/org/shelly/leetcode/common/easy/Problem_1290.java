package cn.org.shelly.leetcode.common.easy;


/**
 * ✔ 二进制链表转整数
 * 链表
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_1290 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public int getDecimalValue(ListNode head) {
            StringBuilder s = new StringBuilder();
            ListNode l = head;
            while(l != null){
                int tmp = l.val;
                s.append((char)('0' + tmp));
                l = l.next;
            }

            double ret = 0;
            for(int i = 0;i<s.length();i++){
                ret += (s.charAt(i) - '0') * Math.pow(2, s.length() - i - 1);
            }
            return (int) ret;
        }
    }
}
