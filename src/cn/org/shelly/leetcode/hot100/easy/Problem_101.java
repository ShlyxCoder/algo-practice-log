package cn.org.shelly.leetcode.hot100.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ✔ 对称二叉树
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_101 {

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
        public boolean isSymmetric(TreeNode root) {
            List<Pair> trace = new ArrayList<>();
            printTrace(root, 0, trace);

            int n = trace.size();
            if (n % 2 != 1) return false;

            for (int i = 0; i < n / 2; i++) {
                Pair a = trace.get(i);
                Pair b = trace.get(n - 1 - i);
                if (!a.equals(b)) return false;
            }
            return true;
        }

        private void printTrace(TreeNode node, int depth, List<Pair> res) {
            if (node == null) {
                res.add(new Pair(depth, "#"));
                return;
            }
            printTrace(node.left, depth + 1, res);
            res.add(new Pair(depth, String.valueOf(node.val)));
            printTrace(node.right, depth + 1, res);
        }

        static class Pair {
            int depth;
            String val;

            Pair(int d, String v) {
                this.depth = d;
                this.val = v;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Pair)) return false;
                Pair other = (Pair) o;
                return this.depth == other.depth && this.val.equals(other.val);
            }
        }
    }

}
