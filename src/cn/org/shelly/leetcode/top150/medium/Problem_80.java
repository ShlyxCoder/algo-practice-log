package cn.org.shelly.leetcode.top150.medium;

public class Problem_80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int idx = 0;
            for(int i = 0;i<nums.length;i++){
                int tmp = nums[i];
                int t = 1;
                int j = i + 1;
                for(;j<nums.length;j++){
                    if(nums[j] == tmp) t++;
                    else{
                        break;
                    }
                }
                if(t > 2) t = 2;
                while(--t >= 0) nums[idx++] = tmp;
                i = j-1;
            }
            return idx;
        }
    }
}
