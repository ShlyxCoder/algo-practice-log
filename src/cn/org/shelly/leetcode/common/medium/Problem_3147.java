package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 从魔法师身上吸取的最大能量
 * @author shelly
 * @date 2025/10/10
 */
public class Problem_3147 {
    class Solution {
        public int maximumEnergy(int[] energy, int k) {
            int maxV = -1000000;
            int idx = energy.length - 1;
            int count = k;
            while(idx >= 0 && count > 0){
                int curV = 0;
                int tmp = idx;
                for(;;tmp-=k){
                    if(tmp < 0){
                        break;
                    }
                    curV += energy[tmp];
                    maxV = Math.max(maxV, curV);
                }
                idx--;
                count--;
            }
            return maxV;
        }
    }
}
