package cn.org.shelly.leetcode.top150.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem_637 {

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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double>list = new ArrayList<>();
            if(root == null) return list;
            Deque<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            int size = 1;
            while(!q.isEmpty()){
                int next = 0;
                double cur = 0.0;
                int pre = size;
                while(size > 0){
                    TreeNode tmp = q.poll();
                    cur+=tmp.val;
                    if(tmp.left != null){
                        q.add(tmp.left);
                        next++;
                    }
                    if(tmp.right != null){
                        q.add(tmp.right);
                        next++;
                    }
                    size--;
                }
                size = next;
                list.add(cur/pre);
            }
            return list;
        }
    }
}
