package cn.org.shelly.leetcode.top150.hard;

import java.util.ArrayList;
import java.util.List;

public class Problem_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            // 确定本行可以放下哪些单词 [i, j)
            int len = words[i].length();
            int j = i + 1;
            while (j < n && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length(); // 加上一个空格和下一个单词长度
                j++;
            }
            // words 从 i 到 j-1 放入本行
            int wordCount = j - i;
            StringBuilder sb = new StringBuilder();

            // 如果是最后一行，或本行只有一个单词，则左对齐
            if (j == n || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    if (k > i) sb.append(' ');
                    sb.append(words[k]);
                }
                // 补右空格
                int remain = maxWidth - sb.length();
                if (remain > 0) sb.append(" ".repeat(remain));
            } else {
                // 不是最后一行，且单词个数 >= 2 -> 两端对齐
                int totalChars = 0;
                for (int k = i; k < j; k++) totalChars += words[k].length();
                int totalSpaces = maxWidth - totalChars;
                int gaps = wordCount - 1;
                int avg = totalSpaces / gaps;
                int extra = totalSpaces % gaps; // 多余的空格从左到右分配

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = avg + (extra > 0 ? 1 : 0);
                        if (extra > 0) extra--;
                        sb.append(" ".repeat(spaces));
                    }
                }
            }

            res.add(sb.toString());
            i = j; // 处理下一行
        }
        return res;
    }
}
