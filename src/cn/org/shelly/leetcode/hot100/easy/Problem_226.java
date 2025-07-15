package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 反转二叉树
 * 递归
 * @author shelly
 * @date 2025/7/15
 */
public class Problem_226 {

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

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return null;
            invert(root);
            return root;
        }
        void invert(TreeNode root){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if(root.left != null) invert(root.left);
            if(root.right != null) invert(root.right);
        }
    }
}
