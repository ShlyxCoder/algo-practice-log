package cn.org.shelly.leetcode.hot100.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 二叉树的中序遍历
 * 遍历
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_94 {

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
        private List<Integer> ret = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            inorder(root);
            return ret;
        }
        void inorder(TreeNode root){
            if(root == null){
                return;
            }
            inorder(root.left);
            ret.add(root.val);
            inorder(root.right);
        }
    }
}
