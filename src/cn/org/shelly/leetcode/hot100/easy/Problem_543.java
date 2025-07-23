package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 二叉树的直径
 * @author shelly
 * @date 2025/7/23
 */
public class Problem_543 {

    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return maxDiameter;
        }

        private int depth(TreeNode node) {
            if (node == null) return 0;
            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);
            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
