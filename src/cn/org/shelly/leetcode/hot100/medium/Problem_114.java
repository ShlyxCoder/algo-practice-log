package cn.org.shelly.leetcode.hot100.medium;

public class Problem_114 {
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
        public void flatten(TreeNode root) {
             dfs(root);
        }
        TreeNode dfs(TreeNode node){
              if(node == null) return null;
           TreeNode left = node.left;
           node.left = null;
           TreeNode right = node.right;
           node.right = dfs(left);
           return node;
        }

    }
}
