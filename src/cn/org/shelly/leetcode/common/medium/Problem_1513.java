package cn.org.shelly.leetcode.common.medium;

public class Problem_1513 {
    class Solution {
        public int numSub(String s) {
            int cnt = 0;
            long ret = 0;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == '1'){
                    cnt++;
                }else{
                    ret += fuc(cnt) % 1000000007;
                    cnt = 0;
                }
            }
            ret += fuc(cnt);
            return(int) ret % 1000000007;
        }
        public long fuc(long n){
            return (1 + n) * n /2 ;
        }
    }
}
