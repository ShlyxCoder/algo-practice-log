package cn.org.shelly.leetcode.hot100.hard;
/**
 * ✔ 二叉树最大路径和
 * @author shelly
 * @date 2025/12/17
 */
public class Problem_124 {
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
        int max = -1000000000;
        public int maxPathSum(TreeNode root) {
            dfs(root);
            return max;
        }
        public int dfs(TreeNode root){
            if(root == null) return 0;
            int maxL = Math.max(dfs(root.left),0);
            int maxR = Math.max(dfs(root.right),0);
            max = Math.max(root.val + maxL + maxR, max);
            return Math.max(maxL,maxR) + root.val;
        }
    }

}
