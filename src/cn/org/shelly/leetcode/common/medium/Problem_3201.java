package cn.org.shelly.leetcode.common.medium;
/**
 * ✔ 找出有效子序列的最大长度 I
 * @author shelly
 * @date 2025/7/16
 */
public class Problem_3201 {
    class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length < 3) return nums.length;
        int a=0 , b=0,c=0 ,d=0;
        int c_need = 1;
        int d_need = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] % 2 == c_need){
                c++;
                c_need = c_need == 1 ? 0 : 1;
            }
            if(nums[i] % 2 == d_need){
                d++;
                d_need = d_need == 1 ? 0 : 1;
            }
            if(nums[i] % 2 == 0){
                a++;
            }else{
                b++;
            }
        }
        return Math.max(Math.max(Math.max(a,b),c),d);
    }
}

}
