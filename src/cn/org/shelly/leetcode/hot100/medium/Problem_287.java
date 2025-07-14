package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 寻找重复数
 * Floyd判圈
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // 第一阶段：找到相遇点（一定在环内），因为一定有环，就一定会死循环，在圈内一定会相遇
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 第二阶段：重新从起点走，找入口
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
//Floyd 判圈算法是基于“函数式映射”构造的一个单链表式结构：
//
//每个节点有且只有一个出边（即：nums[i] → nums[nums[i]]）
//
//当有一个重复值时，这个映射结构必然构成一个环
//
//快慢指针可以用来追踪这个唯一的环


/**
 * 慢指针：L1(环外)+L2(环内对于环入口的偏移)
 * 快指针：2(L1+L2)
 * 2(L1+L2) = L1 + L2 + C(环路径长)
 * L1 + L2 = C
 * 现在以同样速度，一个从环外起点出发，一个从环内相遇点继续
 * 环外起点出发走L1到达环入口，环内速度相同，也走L1，而L1+L2就等于整环长，即回到起点
 */
