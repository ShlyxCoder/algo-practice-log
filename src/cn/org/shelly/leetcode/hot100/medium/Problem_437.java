package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 路径总和 III
 * @author shelly
 * @date 2025/7/29
 */
public class Problem_437 {

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
         int count = 0;
        public int pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum, new ArrayList<>());
            return count;
        }
        private void dfs(TreeNode node, int targetSum, List<Integer> path) {
            if (node == null) return;
            path.add(node.val);
            long sum = 0;
            for (int i = path.size() - 1; i >= 0; i--) {
                sum += path.get(i);
                if (sum == targetSum) {
                    count++;
                }
            }
            dfs(node.left, targetSum, path);
            dfs(node.right, targetSum, path);
            path.remove(path.size() - 1);
        }
    }
}
/**
 * 很巧妙避开了重复，因为倒序遍历相当于判断以当前节点结尾的可能，所以一定不重复,
 * 数字不是全为正数，所以不能中途break
 */
