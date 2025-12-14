package cn.org.shelly.leetcode.common.hard;

public class Problem_2147 {
    class Solution {
        public int numberOfWays(String corridor) {
            int p = 0;
            int ret = 1;
            int cnt = 0;
            int s = 0;
            boolean has = false;
            for(int i = 0;i<corridor.length();i++){
                if(corridor.charAt(i) == 'S'){
                    s++;
                    cnt++;
                    if(cnt == 4){
                        cnt = 2;
                        has = true;
                        ret = (int)((long) ret * (p + 1) % 1000000007);
                        p = 0;
                    }
                }else{
                    if(cnt == 2) p++;
                }
            }
            if(s % 2 == 1)return 0;
            if(!has && cnt < 2) return 0;
            return ret;
        }
    }
}
