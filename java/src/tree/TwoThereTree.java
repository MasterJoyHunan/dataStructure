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
            } else if (key.compareTo(node.leftKey) > 0 && key.compareTo(node.rightKey) < 0) {
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


    private void merge(Node node, K key, V value) {
        // 二节点的情况
        if (!node.isTwoNode) {
            if (key.compareTo(node.leftKey) > 0) {
                node.rightKey = key;
                node.rightValue = value;
                node.isTwoNode = true;
            } else if (key.compareTo(node.leftKey) < 0) {
                node.rightKey = node.leftKey;
                node.rightValue = node.leftValue;
                node.leftKey = key;
                node.leftValue = value;
                node.isTwoNode = true;
            } else {
                node.leftValue = value;
            }
        } else {
            // 3节点情况 需要重排
            if (key.compareTo(node.leftKey) == 0) {
                node.leftValue = value;
                return;
            } else if (key.compareTo(node.rightKey) == 0) {
                node.rightValue = value;
                return;
            }
            K tempKey;
            V tempValue;
            if (key.compareTo(node.leftKey) < 0 ) {
                tempKey = node.leftKey;
                tempValue = node.leftValue;
                node.leftKey = key;
                node.leftValue = value;
            } else if (key.compareTo(node.leftKey) > 0 && key.compareTo(node.rightKey) < 0) {
                tempKey = key;
                tempValue = value;
            } else {
                tempKey = node.rightKey;
                tempValue = node.rightValue;
                node.rightKey = key;
                node.rightValue = value;
            }
            merge(node.parent, tempKey, tempValue);
        }
    }
}
