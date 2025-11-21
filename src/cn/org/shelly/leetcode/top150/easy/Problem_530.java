package cn.org.shelly.leetcode.top150.easy;


public class Problem_530 {
    class Solution {
        int prev = -1;
        int ans = Integer.MAX_VALUE;

        public int getMinimumDifference(Problem_637.TreeNode root) {
            inorder(root);
            return ans;
        }

        private void inorder(Problem_637.TreeNode node) {
            if (node == null) return;

            inorder(node.left);

            if (prev != -1) {
                ans = Math.min(ans, node.val - prev);
            }
            prev = node.val;

            inorder(node.right);
        }
    }

}
