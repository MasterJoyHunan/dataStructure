package tree;

import java.util.TreeMap;

/**
 * leetcode 677
 */
public class MapSum {

    private Node root = new Node();

    private class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }


    public void insert(String key, int val) {
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            char front = key.charAt(i);
            if (!current.next.containsKey(front)) {
                current.next.put(front, new Node());
            }
            current = current.next.get(front);
        }
        current.value = val;
    }

    public int sum(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char front = prefix.charAt(i);
            if (!current.next.containsKey(front)) {
                return 0;
            }
            current = current.next.get(front);
        }
        return sum(current);
    }

    private int sum (Node node) {
        int sum = node.value;
        for(char c: node.next.keySet()) {
            sum += sum(node.next.get(c));
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum trie = new MapSum();
        trie.insert("apple", 3);
        System.out.println(trie.sum("ap"));

        trie.insert("app", 2);
        System.out.println(trie.sum("ap"));
    }
}
