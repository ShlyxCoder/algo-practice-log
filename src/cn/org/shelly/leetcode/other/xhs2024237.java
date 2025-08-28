package cn.org.shelly.leetcode.other;

import java.util.*;
public class xhs2024237 {
    static int idx = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->{
           int cmp = Integer.compare(b.v, a.v); 
    if (cmp != 0) return cmp;
    return Integer.compare(a.num, b.num); 
        });
        Set<String> s = new HashSet<>();
        int a = in.nextInt();
        int b = in.nextInt();
        while(b > 0){
            b--;
            s.add(in.next());
        }
        while(a > 0){
            String key = in.next();
            int num = in.nextInt();
            int count = 0;
            for(int i = 0;i<num;i++){
                String tmp = in.next();
                if(s.contains(tmp)) count++;
            }
            p.add(new Pair(key,count,idx++));
            a--;
        }
        while(!p.isEmpty()) System.out.println(p.poll().k);
    }

   static class Pair{
        String k;
        Integer v;
        int num;
        Pair(String a, Integer b,int n){
            k = a;
            v = b;
            num = n;
        }
    }
}
