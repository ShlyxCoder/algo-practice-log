package cn.org.shelly.leetcode.common.medium;
/**
 * √ 将 1 移动到末尾的最大操作次数
 */
public class Problem_3288 {
    class Solution {
        public int maxOperations(String s) {
            int ret = 0;
            int cnt = 0;
            int idx = 0;
            boolean isAdd = false;
            while(idx < s.length()){
                if(s.charAt(idx) == '1'){
                    if(isAdd) ret+=cnt;
                    isAdd = false;
                    cnt++;
                } else {
                    isAdd = true;
                }
                idx ++ ;
            }
            if(s.charAt(s.length() - 1) == '0'){
                ret += cnt;
            }
            return ret;
        }

    }

}
