package cn.org.shelly.leetcode.hot100.easy;
import cn.org.shelly.leetcode.hot100.easy.Problem_21.ListNode;
/**
 * ✔ 相交链表
 * 遍历
 * @author shelly
 * @date 2025/7/20
 */
public class Problem_160 {

    public class Solution {
        public Problem_21.ListNode getIntersectionNode(Problem_21.ListNode headA, Problem_21.ListNode headB) {
            ListNode p = headA;//len1
            ListNode q = headB;//len2
            int len1 = 0, len2 = 0;
            while(p != null) {
                len1++;
                p = p.next;
            }
            while(q != null) {
                len2++;
                q = q.next;
            }
            ListNode standard , shortNode;
            if(len1 < len2){
                shortNode = headA;
                standard = headB;
            }else{
                shortNode = headB;
                standard = headA;
            }
            int dis = Math.max(len1, len2)-Math.min(len1, len2);
            for(int i = 0; i < dis; i++){
                standard = standard.next;
            }
            while(standard != null && shortNode != null){
                if(standard == shortNode){
                    return standard;
                }
                standard = standard.next;
                shortNode = shortNode.next;
            }
            return null;
        }
    }
}
