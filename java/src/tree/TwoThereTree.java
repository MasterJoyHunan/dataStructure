package tree;

/**
 * 2-3树
 * 一个节点可以存
 */
public class TwoThereTree<K extends Comparable<K>, V> {


    private class Node {
        public K leftKey;
        public K rightKey;
        public V leftValue;
        public V rightValue;

        public boolean isTwoNode = false;
        public Node parent;
        public Node left;
        public Node mid;
        public Node right;

        public Node(K key, V value) {
            this.leftKey = key;
            this.leftValue = value;
        }
    }

    private Node root;


    public void put(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }
        put(root, key, value);
    }

    private void put(Node node, K key, V value) {
        if (!node.isTwoNode) {
            if (key.compareTo(node.leftKey) > 0) {
                if (node.right == null) {
                    node.rightKey = key;
                    node.rightValue = value;
                    node.isTwoNode = true;
                    return;
                }
                put(node.right, key, value);
            } else if (key.compareTo(node.leftKey) < 0) {
                if (node.left == null) {
                    node.leftKey = key;
                    node.leftValue = value;
                    node.isTwoNode = true;
                    return;
                }
                put(node.left, key, value);
            } else {
                node.leftValue = value;
                return;
            }
        } else {
            if (key.compareTo(node.leftKey) < 0) {
                if (node.right == null) {
                    node.rightKey = key;
                    node.rightValue = value;
                    node.isTwoNode = true;
                    return;
                }
                put(node.right, key, value);
            } else if (key.compareTo(node.rightKey) > 0) {
                if (node.left == null) {
                    node.leftKey = key;
                    node.leftValue = value;
                    node.isTwoNode = true;
                    return;
                }
                put(node.left, key, value);
            } else if (key.compareTo(node.leftKey) > 0 && key.compareTo(node.rightKey) < 0){
                if (node.mid == null) {

                }
                put(node.mid, key, value);
            } else if (key.compareTo(node.leftKey) == 0) {
                node.leftValue = value;
            } else if (key.compareTo(node.rightKey) == 0) {
                node.rightValue = value;
            }
        }
    }
}
