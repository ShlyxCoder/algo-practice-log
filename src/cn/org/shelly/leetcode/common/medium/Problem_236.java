package cn.org.shelly.leetcode.common.medium;

/**
 * 二叉树的最近公共祖先
 * @author shelly
 */

public class Problem_236 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {
        public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor_2(root.left, p, q);
            TreeNode right = lowestCommonAncestor_2(root.right, p, q);
            if(left != null && right != null) return root;
            return left != null ? left : right;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == p || root == q) return root;
            boolean b = find(root.left, p);
            boolean c = find(root.left, q);
            if(b == c){
                if(b){
                   return lowestCommonAncestor(root.left,p,q);
                }else{
                    return lowestCommonAncestor(root.right,p,q);
                }
            }else{
                return root;
            }
        }
        public boolean find(TreeNode tree, TreeNode target){
            if(tree == null) return false;
            if(tree == target) return true;
            return find(tree.left,target) || find(tree.right,target);
        }

    }
}
