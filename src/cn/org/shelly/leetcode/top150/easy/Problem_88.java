package cn.org.shelly.leetcode.top150.easy;

public class Problem_88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1,j = n-1;
            int idx = m+n-1;
            while(i >= 0 && j >= 0){
                if(nums1[i] > nums2[j]){
                    nums1[idx--] = nums1[i];
                    i--;
                }
                else{
                    nums2[idx--] = nums2[j];
                    j--;
                }
            }
            while(i >= 0) {
                nums1[idx--] = nums1[i];
                i--;
            }
            while(j >= 0) {
                nums1[idx--] = nums2[j];
                j--;
            }

        }
    }
}
