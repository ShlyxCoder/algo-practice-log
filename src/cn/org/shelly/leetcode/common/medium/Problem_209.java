package cn.org.shelly.leetcode.common.medium;
/**
 * 长度最小的子数组
 * @author shelly
 * @date 2025/9/15
 */
public class Problem_209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ret = 1000000;
            int l = 0;
            int r = 0;
            int cur = 0;
            while(r < nums.length && l <= r){
                cur += nums[r++];
                if(cur>=target){
                    ret = Math.min(ret,r-l);
                    while(l<=r){
                        cur-=nums[l++];
                        if(cur<target) break;
                        else{
                            ret = Math.min(ret,r-l);
                        }
                    }
                }
            }
            return ret == 1000000 ? 0:ret;
        }

    }
}
