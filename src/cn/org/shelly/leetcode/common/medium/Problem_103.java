package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ✔ 二叉树的锯齿形层序遍历
 * @author shelly
 * @date 2025/9/5
 */
public class Problem_103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        int count = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        boolean left = true;
        while(!deque.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int current = 0;
            while(count > 0){
                TreeNode t = null;
                if(left) t = deque.removeFirst();
                if(!left) t = deque.removeLast();
                tmp.add(t.val);
                if(!left){
                    if(t.right != null){
                        deque.addFirst(t.right);
                        current++;
                    }
                    if(t.left != null){
                        deque.addFirst(t.left);
                        current++;
                    }
                }
                else{
                    if(t.left != null){
                        deque.addLast(t.left);
                        current++;
                    }
                    if(t.right != null){
                        deque.addLast(t.right);
                        current++;
                    }
                }
                count--;
            }
            left = !left;
            count = current;
            list.add(tmp);
        }
        return list;
    }
}
}
