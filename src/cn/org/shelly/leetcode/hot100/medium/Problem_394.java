package cn.org.shelly.leetcode.hot100.medium;

import java.util.Stack;
/**
 * ✔ 字符串解码
 * @author shelly
 * @date 2025/7/16
 */
public class Problem_394 {
    class Solution {

        public String decodeString(String s) {
            Stack<Character> st = new Stack<>();
            for(Character c:s.toCharArray()){
                if(c != ']') {
                    st.push(c);
                    continue;
                }
                StringBuilder help = new StringBuilder();
                while(!st.isEmpty()){
                    char tmp = st.pop();
                    if(tmp == '[') break;
                    help.insert(0, tmp);
                }
                int num = 0;
                int p = 1;
                while(!st.isEmpty()){
                    char tmp = st.peek();
                    if(tmp <'0' || tmp>'9') break;
                    st.pop();
                    num += (tmp -'0')*p;
                    p*=10;
                }
                String repeated = help.toString();
                for (int i = 0; i < num; i++) {
                    for (char ch : repeated.toCharArray()) {
                        st.push(ch);
                    }
                }
            }
            StringBuilder ret = new StringBuilder();
            while(!st.isEmpty()){
                ret.insert(0, st.pop());
            }
            return ret.toString();
        }
    }
}
