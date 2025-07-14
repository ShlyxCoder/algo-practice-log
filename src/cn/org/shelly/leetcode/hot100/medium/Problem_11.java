package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 乘最多水的容器
 * 双指针
 * @author shelly
 * @date 2025/7/14
 */
public class Problem_11 {
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            int l = 0, r = height.length-1;
            while(l<r){
                int cur = (r-l)*Math.min(height[r], height[l]);
                max = Math.max(cur,max);
                if(height[r] > height[l]){
                    l++;
                }
                else{
                    r--;
                }
            }
            return max;
        }
    }
}
