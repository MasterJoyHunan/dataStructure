package map;

import queue.QueueLinked;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author joy
 * @date 2019/09/12 15:20
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K, V>, Iterator<K>, Iterable {

    public class Node {
        private K    key;
        private V    value;
        private Node left;
        private Node right;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Node root;
    private int  size;

    /**
     * 插入/修改 数据
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
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
        return node;
    }

    /**
     * 根据Key 删除某条数据
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        V v = get(key);
        if (v == null) {
            return null;
        }
        root = remove(root, key);
        return v;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
        } else {
            if (node.left != null && node.right != null) {
                Node temp = max(node.left);
                node.key = temp.key;
                node.left = remove(node.left, temp.key);
            } else {
                node = node.left != null ? node.left : node.right;
                size--;
            }
        }
        return node;
    }

    /**
     * 根据Key获取某条数据
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node node = get(key, root);
        return node == null ? null : node.value;
    }

    private Node get(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return get(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            return get(key, node.left);
        } else {
            return node;
        }
    }


    /**
     * 判断Key是否在当前容器里面
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return get(key, root) != null;
    }


    /**
     * 判断容器是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取当前容器元素的个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * 获取最大值
     *
     * @return
     */
    public V max() {
        if (root == null) {
            throw new IllegalArgumentException("数据为空");
        }
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public V min() {
        if (root == null) {
            throw new IllegalArgumentException("数据为空");
        }
        return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    // 游标
    private QueueLinked<Node> queueLinked = new QueueLinked<>();
    private boolean start = true;

    @Override
    public boolean hasNext() {
        if (start) {
            if (size == 0) {
                return false;
            }
            queueLinked.enqueue(root);
            start = false;
            return true;
        }
        return queueLinked.getSize() != 0;
    }

    @Override
    public K next() {
        Node node = queueLinked.dequeue();
        if (node.left != null) {
            queueLinked.enqueue(node.left);
        }
        if (node.right != null) {
            queueLinked.enqueue(node.right);
        }
        return node.key;
    }

    @Override
    public Iterator iterator() {

        return null;
    }


    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(2, "8831q64");
        tree.put(6, "dsg");
        tree.put(4, "ha");
        tree.put(13, "asd");
        tree.put(1, "88fg64");

//        tree.remove(2);
//        tree.remove(1);
        System.out.println(tree);
        while (tree.hasNext()) {
            System.out.println(tree.get(tree.next()));
        }
    }
}

