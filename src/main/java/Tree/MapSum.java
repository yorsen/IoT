package Tree;

import Tree.Trie.TrieNode;

/**
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 * 如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * @author yaosen.pys
 * @date 2021/07/07
 */
public class MapSum {
    TrieNode root;

    public class TrieNode {
        int count;
        int preCount;
        int val;
        int totalVal;
        TrieNode[] nextNode = new TrieNode[26];

        public TrieNode() {
            preCount = 0;
            totalVal = 0;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        if (null == key || key.length() == 0) {
            return;
        }
        int preValue = search(key);
        TrieNode pre = root;
        char[] wordChar = key.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                pre.nextNode[wordChar[i] - 'a'] = new TrieNode();
            }
            pre = pre.nextNode[wordChar[i] - 'a'];
            pre.preCount++;
            pre.totalVal = pre.totalVal - preValue + val;
        }

        pre.count++;
        pre.val = val;
    }

    public int search(String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }

        TrieNode pre = root;
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                return 0;
            }

            pre = pre.nextNode[wordChar[i] - 'a'];
        }

        if (pre.count == 0) {
            return 0;
        }

        return pre.val;
    }

    public int sum(String prefix) {
        if (null == prefix || prefix.length() == 0) {
            return 0;
        }
        TrieNode pre = root;
        char[] wordChar = prefix.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            if (pre.nextNode[wordChar[i] - 'a'] == null) {
                return 0;
            }
            pre = pre.nextNode[wordChar[i] - 'a'];
        }

        return pre.totalVal;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)

        System.out.println(mapSum.sum("app")); //5

        System.out.println(mapSum.sum("appl")); //3

        mapSum.insert("apple", 2);

        System.out.println(mapSum.sum("app")); //4


    }
}
