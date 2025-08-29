package cn.org.shelly.leetcode.hot100.medium;
/**
 * ✔ 最长回文子串
 * @author shelly
 * @date 2025/8/29
 */
public class Problem_5 {
    class Solution {
        int ret = 1;
        int begin = 0;
        int end = 1;
        public String longestPalindrome(String s) {
            char[] arr = s.toCharArray();
            int n = s.length();
            for(int i = 0; i < n - 1; i++){
                expand(arr, i,i);
                expand(arr,i,i+1);
            }
            return s.substring(begin, end);
        }
        void expand(char[] arr, int l,int r){
            if(l != r && arr[l] != arr[r]) return;
            int count = (l == r ? 1 : 2);
            l--;
            r++;
            while(l >=0 && r< arr.length && arr[l] == arr[r]){
                count += 2;
                l--;
                r++;
            }
            if(count > ret) {
                ret = count;
                begin = l + 1;
                end = r;
            }
        }
    }
}
