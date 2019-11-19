package tree;

/**
 * 红黑树(左倾红黑树)
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int size = 0;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        boolean color = RED;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public V get(K key) {
        return get(key, root);
    }

    public V get(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return get(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            return get(key, node.left);
        }
        return node.value;
    }

    /**
     * 插入/修改 数据
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        root = put(key, value, root);
        root.color = BLACK;
    }

    private Node put(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = put(key, value, node.right);
        } else if (key.compareTo(node.key) < 0) {
            node.left = put(key, value, node.left);
        } else {
            node.value = value;
        }

        // 判断右孩子是否是红色,如果是,这将
        if (getColor(getRightChild(node)) && !getColor(getLeftChild(node))) {
            // 右旋
            node = rightRotate(node);
        }

        // 判断左孩子,以及左孩子的左孩子的颜色是否都是红色
        if (getColor(getLeftChild(node)) && getColor(getLeftChild(getLeftChild(node)))) {
            // 左旋
            node = leftRotate(node);
        }

        // 如果左右孩子都是红色, 则颜色翻转
        if (getColor(getLeftChild(node)) && getColor(getRightChild(node))) {
            flipColors(node);
        }
        return node;
    }


    /**
     * 右旋转 交换颜色
     *
     * @param node
     */
    private Node rightRotate(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }


    /**
     * 左旋 交换颜色
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        // 交换颜色
        temp.color = node.color;
        node.color = RED;
        return temp;
    }


    private void flipColors(Node node) {
        setColor(node, RED);
        setColor(node.left, BLACK);
        setColor(node.right, BLACK);
    }


    private void setColor(Node node, boolean color) {
        if (node == null) {
            return;
        }
        node.color = color;
    }

    private boolean getColor(Node node) {
        return node == null ? BLACK : node.color;
    }

    private Node getLeftChild(Node node) {
        if (node == null || node.left == null) {
            return null;
        }
        return node.left;
    }

    private Node getRightChild(Node node) {
        if (node == null || node.right == null) {
            return null;
        }
        return node.right;
    }

    public int getSize() {
        return size;
    }


    public boolean containers(K key) {

        return get(key) != null;
    }

    public static void main(String[] args) {
        RBTree<Integer, Integer> rb = new RBTree<>();
//        Random r = new Random();
        long startTime = System.nanoTime();
        for (int i = 1; i <= 7; i++) {
            rb.put(i, null);
        }
        System.out.println(System.nanoTime() - startTime);
    }

}
