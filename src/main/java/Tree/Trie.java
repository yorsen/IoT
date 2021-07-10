package Tree;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/07/07
 */
public class Trie {
    TrieNode root;

    public class TrieNode {
        int count;
        int preCount;
        TrieNode[] nextNode = new TrieNode[26];

        public TrieNode() {
            count = 0;
            preCount = 0;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null == word || word.length() == 0) {
            return;
        }
        TrieNode pre = root;
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                pre.nextNode[wordChar[i] - 'a'] = new TrieNode();
            }
            pre = pre.nextNode[wordChar[i] - 'a'];
            pre.preCount++;
        }

        pre.count++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieNode pre = root;
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                return false;
            }

            pre = pre.nextNode[wordChar[i] - 'a'];
        }

        if (pre.count == 0) {
            return false;
        }

        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }

        TrieNode pre = root;
        char[] wordChar = prefix.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                return false;
            }

            pre = pre.nextNode[wordChar[i] - 'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app"));  // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
