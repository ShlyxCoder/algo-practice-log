package cn.org.shelly.leetcode.hot100.medium;
/**
 * ？ 二叉树展开为链表
 * @author shelly
 * @date 2025/7/29
 */
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
            if(root == null) return;
            dfs(root);
        }
        void dfs(TreeNode node){
            if(node == null) return;
            TreeNode left = node.left;
            TreeNode right = node.right;
            dfs(left);
            dfs(right);
            if(left != null){
                node.right = left;
                TreeNode p = left;
                while(p.right != null) p = p.right;
                p.right = right;
            }
            node.left = null;
        }
        void morris(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    // 找左子树的最右节点
                    TreeNode prev = curr.left;
                    while (prev.right != null) {
                        prev = prev.right;
                    }
                    // 将当前节点的右子树接到左子树的最右节点上
                    prev.right = curr.right;

                    // 将左子树接到右边，左置空
                    curr.right = curr.left;
                    curr.left = null;
                }
                // 继续访问右子树
                curr = curr.right;
            }
        }

    }}
