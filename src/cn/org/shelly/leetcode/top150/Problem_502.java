package cn.org.shelly.leetcode.top150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_502 {
    class Solution {
        class Pair{
            int need;
            int pro;
            Pair(int n, int p){
                need = n;
                pro = p;
            }
        }
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->b.pro-a.pro);
            List<Pair> list = new ArrayList<>();
            for(int i = 0;i<capital.length;i++){
                list.add(new Pair(capital[i], profits[i]));
            }
            list.sort((a, b) -> a.need - b.need);
            int idx = 0;
            while(k > 0){
                for(;idx<list.size();idx++){
                    Pair pair = list.get(idx);
                    if(pair.need > w) break;
                    p.add(pair);
                }
                if(!p.isEmpty())w += p.poll().pro;
                k--;
            }
            return w;
        }
    }
}
