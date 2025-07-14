package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
/**
 * ✔ 二叉树的层序遍历
 * 遍历
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_102 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            if(root == null) return ret;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int cur = 1;
            while(!queue.isEmpty()){
                int next = 0;
                List<Integer> list = new ArrayList<>();
                for(int i = 0;i<cur;i++){
                    TreeNode t = queue.poll();
                    list.add(t.val);
                    if(t.left != null){
                        queue.add(t.left);
                        next++;
                    }
                    if(t.right != null){
                        queue.add(t.right);
                        next++;
                    }
                }
                ret.add(list);
                cur = next;

            }
            return ret;
        }
    }
}
