package cn.org.shelly.leetcode.other;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class xhs {
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> {
            if(a.v != b.v){
                return b.v - a.v;
            }
            return a.key.compareTo(b.key);
        });
        HashMap<String,Integer> h = new HashMap<>();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.next();
            h.put(s,h.getOrDefault(s,0)+1);
        }
        for(Map.Entry<String,Integer> e:h.entrySet()){
            p.add(new Pair(e.getKey(),e.getValue()));
        }
        while(!p.isEmpty() && p.peek().v >=3){
            Pair k = p.poll();
            System.out.println(k.key); 
        }

    }
   static class Pair{
        String key;
        Integer v;
        Pair(String a, Integer b){
            key = a;
            v = b;
        }
    }
} 

/*
小红所有的关键词。每行输入一个。你需要按照搜索频次从高到低输出。频次相同的，你需要按字典序升序输出。
 */