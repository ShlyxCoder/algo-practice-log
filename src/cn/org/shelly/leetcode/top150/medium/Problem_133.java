package cn.org.shelly.leetcode.top150.medium;

import java.util.*;

public class Problem_133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    class Solution {
        private final Map<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            return deepCopy(node);
        }

        private Node deepCopy(Node node) {
            // 如果已经拷贝过这个节点，直接返回
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // 创建新节点（先不管 neighbors）
            Node clone = new Node(node.val);
            visited.put(node, clone);

            // 递归拷贝邻居
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(deepCopy(neighbor));
            }

            return clone;
        }
    }

}
