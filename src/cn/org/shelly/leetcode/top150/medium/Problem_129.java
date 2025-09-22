package cn.org.shelly.leetcode.top150.medium;

public class Problem_129 {
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
        int ret = 0;
        public int sumNumbers(TreeNode root) {
            if(root == null) return 0;
            fuc(root,0);
            return ret;
        }
        void fuc(TreeNode node, int pre){
            if(node.left == null && node.right == null){
                ret += (pre * 10 + node.val);
                return;
            }

            if(node.left!=null)fuc(node.left, pre*10+node.val);
            if(node.right!=null)fuc(node.right, pre*10+node.val);
        }
    }
}
