package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 二叉树的最大深度
 * 遍历
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_104 {
    class Solution {
        public class TreeNode {
            int val;
            Problem_104.Solution.TreeNode left;
            Problem_104.Solution.TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, Problem_104.Solution.TreeNode left, Problem_104.Solution.TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            return deep(root);
        }
        int deep(TreeNode root){
            if(root == null){
                return 0;
            }
            return Math.max(deep(root.left),deep(root.right))+1;
        }
    }
}
