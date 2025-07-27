package cn.org.shelly.leetcode.common.easy;

import java.util.List;
import java.util.stream.IntStream;
/**
 * ✔ 查找包含给定字符的单词
 * @author shelly
 * @date 2025/7/27
 */
public class Problem_2942 {
    class Solution {
        public List<Integer> findWordsContaining(String[] words, char x) {
            return IntStream.range(0, words.length)
                    .filter(i -> words[i].indexOf(x) >= 0)
                    .boxed()
                    .toList();
        }
    }
}
