package cn.org.shelly.leetcode.common.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ✔ 无需开会的工作日
 * 区间合并
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_3169 {
    class Struct {
        int left;
        int right;
         Struct(int a, int b){
             left = a;
             right = b;
         }
    }

    class Solution {
        public int countDays(int days, int[][] meetings) {
            List<Struct> list = new ArrayList<>(meetings.length);
            for(int i = 0;i< meetings.length;i++){
                int [] arr = meetings[i];
                list.add(new Struct(arr[0], arr[1]));
            }
            list.sort(Comparator.comparingInt(s -> s.left));
            list = merge(list);
            int ret = list.get(0).left - 1;
            int idx = 1;
            while(idx < list.size()){
                Struct tmp = list.get(idx);
                if(tmp.left > list.get(idx-1).right){
                    ret += tmp.left - list.get(idx-1).right -1;
                }
                idx++;
            }
            if(list.get(list.size()-1).right <= days){
                ret += days-list.get(list.size()-1).right;
            }
            return ret;
        }

        private List<Struct> merge(List<Struct> list) {
            List<Struct> ret = new ArrayList<>();
            Struct pre = list.get(0);
            for(int i = 1;i< list.size();i++){
                Struct cur = list.get(i);
                if(cur.left > pre.right){
                    ret.add(pre);
                    pre = cur;
                }
                else if(pre.right > cur.right){
                    continue;
                }
                else{
                    pre.right = cur.right;
                }

            }
            list.add(pre);
            return ret;
        }
    }
}
