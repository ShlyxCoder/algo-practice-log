package cn.org.shelly.leetcode.top150.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Problem_380 {

    class RandomizedSet {
        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private Random rand;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            rand = new Random();
        }
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(idx, last);
            map.put(last, idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        public int getRandom() {
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }

}
