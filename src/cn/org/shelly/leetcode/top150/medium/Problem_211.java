package cn.org.shelly.leetcode.top150.medium;

public class Problem_211 {
    class WordDictionary {
        Token all = new Token();
        class Token {
            boolean isEnd;
            Token[] array = new Token[27];
            Token(boolean _end) {
                this.isEnd = _end;
            }
            Token() {}
        }
        public void addWord(String word) {
            Token node = this.all;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                int idx = cur - 'a';
                if (node.array[idx] == null) {
                    node.array[idx] = new Token(false);
                }
                node = node.array[idx];
                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            return helpSearch(all, word, 0);
        }

        private boolean helpSearch(Token node, String word, int idx) {
            if (idx == word.length()) return node.isEnd;
            char c = word.charAt(idx);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.array[i] != null && helpSearch(node.array[i], word, idx + 1)) {
                            return true;
                        }
                }
                return false;
            } else {
                int k = c - 'a';
                if (node.array[k] == null) return false;
                return helpSearch(node.array[k], word, idx + 1);
            }
        }
    }

}
