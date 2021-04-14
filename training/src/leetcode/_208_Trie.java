package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _208_Trie {
    List<String> list;
    /** Initialize your data structure here. */
    public _208_Trie() {
        list = new ArrayList<>();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        list.add(word);
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return list.contains(word);
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : list) {
            if (s.length() >= prefix.length() && prefix.equals(s.substring(0, prefix.length()))) {
                return true;
            }
        }
        return false;
    }

//    字典树
//    private Trie[] children;
//    private boolean isEnd;
//    public Trie() {
//        children = new Trie[26];
//        isEnd = false;
//    }
//    public void insert(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            int index = ch - 'a';
//            if (node.children[index] == null) {
//                node.children[index] = new Trie();
//            }
//            node = node.children[index];
//        }
//        node.isEnd = true;
//    }
//    public boolean search(String word) {
//        Trie node = searchPrefix(word);
//        return node != null && node.isEnd;
//    }
//    public boolean startsWith(String prefix) {
//        return searchPrefix(prefix) != null;
//    }
//    private Trie searchPrefix(String prefix) {
//        Trie node = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            char ch = prefix.charAt(i);
//            int index = ch - 'a';
//            if (node.children[index] == null) {
//                return null;
//            }
//            node = node.children[index];
//        }
//        return node;
//    }
}
