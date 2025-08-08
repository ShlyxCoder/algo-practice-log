package cn.org.shelly.leetcode.hot100.easy;
/**
 * ✔ 将有序数组转换为二叉搜索树
 * @author shelly
 * @date 2025/8/8
 */
public class Problem_108 {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return createTree(nums,0,nums.length);
        }
        TreeNode createTree(int [] nums,int l,int r){
            if(l>r || l >= nums.length || r <0) return null;
            if(l == r){
                return new TreeNode(nums[l],null,null);
            }

            int mid = (l + r) >> 1;
            TreeNode node = new TreeNode(nums[mid],null,null);
            node.left = createTree(nums,l,mid-1);
            node.right = createTree(nums,mid+1,r);
            return node;
        }
    }
}
