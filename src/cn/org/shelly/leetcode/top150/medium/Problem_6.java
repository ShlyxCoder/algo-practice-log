package cn.org.shelly.leetcode.top150.medium;

public class Problem_6 {
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1) return s;
            int num = numRows * 2 - 2;
            int tmp = num;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<numRows;i++){
                if(i == 0 || i == numRows-1){
                    int j = i;
                    while(j < s.length()){
                        sb.append(s.charAt(j));
                        j += num;
                    }
                }else{
                    tmp -= 2;
                    int k = tmp;
                    int j = i;
                    while(j< s.length()){
                        sb.append(s.charAt(j));
                        j += k;
                        k = (num - k);
                    }
                }
            }
            return sb.toString();
        }
    }
}
