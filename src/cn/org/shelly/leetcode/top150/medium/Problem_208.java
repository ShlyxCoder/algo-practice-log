package cn.org.shelly.leetcode.top150.medium;

public class Problem_208 {
    class Trie {
        Token all = new Token();
        class Token {
            boolean isEnd;
            Token[] array = new Token[27];
            Token(boolean _end) {
                this.isEnd = _end;
            }
            Token() {}
        }

        public Trie() {

        }

        public void insert(String word) {
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
            int k = c - 'a';
            if (node.array[k] == null) return false;
            return helpSearch(node.array[k], word, idx + 1);
        }

        public boolean startsWith(String prefix) {
            Token node = this.all;
            for(int i = 0;i<prefix.length();i++){
                char c = prefix.charAt(i);
                Token tmp = node.array[c - 'a'];
                if(tmp == null) return false;
                if(i == prefix.length() - 1){
                    return true;
                }
                node = tmp;
            }
            return false;
        }
    }
}
