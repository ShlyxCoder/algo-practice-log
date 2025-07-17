package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 验证二叉搜索树
 * 递归
 * @author shelly
 * @date 2025/7/17
 */
public class Problem_96 {

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
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode node, long lower, long upper) {
            if (node == null) return true;

            if (node.val <= lower || node.val >= upper) return false;

            return helper(node.left, lower, node.val) &&
                    helper(node.right, node.val, upper);
        }
    }

}
