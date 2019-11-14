package tree;

import map.TreeMap;

/**
 * @author joy
 * @time 2019/11/14 09:34
 */
public class Trie {

    private Node root;
    private int  size;

    private class Node {
        public boolean                  isWordEnd;
        public TreeMap<Character, Node> next;

        public Node(boolean isWordEnd) {
            this.isWordEnd = isWordEnd;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }


    public Trie() {
        this.root = new Node();
        size = 0;
    }

    /**
     * 向tree 添加单词
     *
     * @param word
     */
    public void add(String word) {
        add(root, word);
    }

    private void add(Node current, String word) {
        if (word == null || "".equals(word)) {
            return;
        }
        char front   = word.charAt(0);
        Node element = current.next.get(front);
        if (element == null) {
            current.next.put(front, new Node());
            element = current.next.get(front);
        }

        // 判断是否是结尾
        if (word.length() == 1 && !element.isWordEnd) {
            element.isWordEnd = true;
            size++;
        }

        add(element, word.substring(1));
    }


    /**
     * 判断某个单词是否在trie内
     *
     * @param word
     * @return
     */
    public boolean containers(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char front = word.charAt(i);
            current = current.next.get(front);
            if (current == null) {
                return false;
            }
        }
        return current.isWordEnd;
    }

    /**
     * 判断单词前缀是否在trie内
     *
     * @param word
     * @return
     */
    public boolean isPrefix(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char front = word.charAt(i);
            current = current.next.get(front);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 搜索可以包含 [ . ] 的任意字符串 如 e.d
     *
     * @param word
     * @return
     */
    public boolean isPrefixGrep(String word) {
        if (word == null || "".equals(word)) {
            throw new IllegalArgumentException("参数错误");
        }
        return isPrefixGrep(root, word, 0);
    }

    private boolean isPrefixGrep(Node current, String word, int index) {
        if (index == word.length()) {
            return current.isWordEnd;
        }
        char front = word.charAt(index);
        if (front != '.') {
            current = current.next.get(front);
            if (current == null) {
                return false;
            }
            return isPrefixGrep(current, word, index+1);
        } else {
            // 遍历
            while (current.next.hasNext()) {
                char t = current.next.next();
                if( isPrefixGrep(current.next.get(t), word, index+1)){
                    return true;
                }
            }
            return false;
        }
    }


    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello");
        System.out.println(trie.containers("h"));
        System.out.println(trie.containers("o"));
        System.out.println(trie.containers("lo"));
        System.out.println(trie.containers("he"));
        System.out.println(trie.containers("hello"));

        System.out.println(trie.isPrefix("h"));
        System.out.println(trie.isPrefix("o"));
        System.out.println(trie.isPrefix("lo"));
        System.out.println(trie.isPrefix("he"));
        System.out.println(trie.isPrefix("hello"));


        System.out.println();
        System.out.println(trie.isPrefixGrep("hl..o"));
        System.out.println(trie.isPrefixGrep("h...o"));
        System.out.println(trie.isPrefixGrep("hle.o"));
        System.out.println(trie.isPrefixGrep("hel.o"));
    }
}
