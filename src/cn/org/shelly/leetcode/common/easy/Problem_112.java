package cn.org.shelly.leetcode.common.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 路径总和
 * @author shelly
 * @date 2025/7/29
 */
public class Problem_112 {

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

        public boolean hasPathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum, new ArrayList<>());
            return count > 0;
        }
        int count = 0;

        private void dfs(TreeNode node, int targetSum, List<Integer> path) {
            if (node == null) return;
            path.add(node.val);
            if(node.left == null && node.right == null){
                long sum = path.stream().mapToLong(Integer::longValue).sum();
                if(sum == targetSum) count++;
            }
            dfs(node.left, targetSum, path);
            dfs(node.right, targetSum, path);
            path.remove(path.size() - 1);
        }
    }
}
