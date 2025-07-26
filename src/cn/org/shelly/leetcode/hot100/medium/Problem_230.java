package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 二叉搜索树中第K小的元素
 * @author shelly
 * @date 2025/7/26
 */
public class Problem_230 {
    class Solution {
        int count = 0;
        int target = -1;
        public int kthSmallest(Problem_102.TreeNode root, int k) {
            dfs(root,k);
            return target;
        }
        void dfs(Problem_102.TreeNode node, int k){
            if(node == null) return;
            dfs(node.left,k);
            count ++;
            if(count == k) target = node.val;
            dfs(node.right,k);
        }
    }
}
