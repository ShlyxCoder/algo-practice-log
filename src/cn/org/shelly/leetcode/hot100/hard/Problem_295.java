package cn.org.shelly.leetcode.hot100.hard;

import java.util.PriorityQueue;
/**
 * ✔ 数据流的中位数
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_295 {
    class MedianFinder {
        PriorityQueue<Integer> s = new PriorityQueue<>();// 最小,保存最大的一半
        PriorityQueue<Integer> b = new PriorityQueue<>((a,b) -> Integer.compare(b,a));// 最大，保存最小的一半

        int size = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if(size == 0) s.add(num);
            else if(size == 1){
                b.add(num);
                if(s.peek() < b.peek()){
                    int t1 = s.poll();
                    int t2 = b.poll();
                    b.add(t1);
                    s.add(t2);
                }
            }else{
                if(num > s.peek()){
                    s.add(num);
                }
                else{
                    b.add(num);
                }
                check();
            }
            size++;
        }
        void check(){
            if(Math.abs(s.size() - b.size()) > 1){
                if (b.size() > s.size() + 1) {
                    s.add(b.poll());
                } else if (s.size() > b.size() + 1) {
                    b.add(s.poll());
                }
            }
        }


        public double findMedian() {
          if(size < 2) {
              return s.isEmpty() ? b.peek() : s.peek();
          }
          else{
              return s.size() == b.size() ? (s.peek() + b.peek()) / 2.0 : (s.size() > b.size() ? s.peek() : b.peek());
          }
        }
    }
}
