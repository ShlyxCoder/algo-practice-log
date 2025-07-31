package cn.org.shelly.leetcode.common.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * ✔ 杨辉三角
 * @author shelly
 * @date 2025/8/1
 */
public class Problem_118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>(List.of(1)));
            for(int i = 1;i<numRows;i++){
                List<Integer> row = new ArrayList<>(2);
                row.add(1);
                for(int j = 1;j<i;j++){
                    row.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
                }
                row.add(1);
                ret.add(row);
            }
            return ret;
        }
    }
}
