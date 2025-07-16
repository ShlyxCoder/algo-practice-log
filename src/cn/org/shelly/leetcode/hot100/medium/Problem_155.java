package cn.org.shelly.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 最小栈
 * @author shelly
 * @date 2025/7/16
 */
public class Problem_155 {
    class MinStack {
        List<Integer> list = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            list.add(val);
            if(minVal >= val){
                minVal = val;
            }
        }

        public void pop() {
            if(list.isEmpty()) return;
            list.remove(list.size()-1);
            minVal = list.stream().min(Integer::compare).orElse(Integer.MAX_VALUE);

        }

        public int top() {
            if(list.isEmpty()) return 0;
            return list.get(list.size()-1);
        }

        public int getMin() {
            return minVal;
        }
    }
}
/**
 * 最好是构造辅助"栈"，时刻保存当前元素存入时的最小值即可
 */