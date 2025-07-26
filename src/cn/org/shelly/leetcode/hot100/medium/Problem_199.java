package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * ✔ 二叉树的右视图
 * @author shelly
 * @date 2025/7/26
 */
public class Problem_199 {
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

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if(root == null) return ret;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int cur = 1;
            while(!queue.isEmpty()){
                int next = 0;
                for(int i = 0;i<cur;i++){
                    TreeNode t = queue.poll();
                    if(i == cur -1) ret.add(t.val);
                    if(t.left != null){
                        queue.add(t.left);
                        next++;
                    }
                    if(t.right != null){
                        queue.add(t.right);
                        next++;
                    }
                }
                cur = next;
            }
            return ret;
        }
    }
}
