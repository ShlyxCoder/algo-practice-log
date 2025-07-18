package cn.org.shelly.leetcode.hot100.medium;

import java.util.Stack;
/**
 * ✔ 每日温度
 * 单调栈
 * @author shelly
 * @date 2025/7/18
 */
public class Problem_739 {
    class Pair{
        int idx;
        int val;
        Pair(int idx , int val){
            this.idx = idx;
            this.val = val;
        }
    }

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int [] arr = new int[temperatures.length];
            Stack<Pair> s = new Stack<>();
            for(int i = 0;i<temperatures.length;i++){
                if(s.isEmpty()){
                    s.push(new Pair(i, temperatures[i]));
                    continue;
                }
                int num = temperatures[i];
                while(!s.isEmpty()){
                    Pair top = s.peek();
                    if(top.val < num){
                        s.pop();
                        arr[top.idx] = i - top.idx;
                    }
                    else{
                        break;
                    }
                }
                s.push(new Pair(i, temperatures[i]));
            }
            return arr;
        }
    }
}
