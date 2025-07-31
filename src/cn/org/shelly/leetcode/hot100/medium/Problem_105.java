package cn.org.shelly.leetcode.hot100.medium;

/**
 * ? 从前序与中序遍历序列构造二叉树
 * @author shelly
 * @date 2025/7/30
 */
public class Problem_105 {

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
        int preIndex = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preIndex = 0;
            return createTree(0, inorder.length - 1, preorder, inorder);
        }

        public TreeNode createTree(int l, int r, int[] preorder, int[] inorder) {
            if (l > r) return null;
            int target = preorder[preIndex++];
            TreeNode node = new TreeNode(target);
            int idx = 0;
            for(int i = l;i<= r;i++){
                if(inorder[i] == target) {
                    idx = i ;
                    break;
                }
            }
            node.left = createTree(l, idx - 1, preorder, inorder);
            node.right = createTree(idx + 1, r, preorder, inorder);
            return node;
        }


    }
}
/**
 * 在 preorder 中我们从前往后遍历，每次遇到的元素都是当前子树的根
 * 每次维护的这个左右区间,其实就只跟中序遍历有关，因为前序的头直接就是每次加一即可
 */