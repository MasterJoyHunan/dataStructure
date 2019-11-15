package base;

import map.Map;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public int height = 1;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size = 0;

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
            node.right = put(key, value, node.left);
        } else {
            node.value = value;
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // ============ 重点 =============
        // 对树进行回溯,如果树不平衡,将对树进行平衡操作
        int balanceFactor = getBalanceFactor(node);

        // 如果该树的左子树不平衡,并且左子树的左边高与等于右边 进行LL旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            node = LL_Rotate(node);
        }

        // 如果该树的左子树不平衡,并且左子树的左边低于右边 进行LR旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node = LR_Rotate(node);
        }

        // 如果该树的右边不平衡,并且该右子树的的左边低于等于右边,进行RR旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            node = RR_Rotate(node);
        }

        // 如果该树的右边不平衡,并且该右子树的的左边高于右边,进行RL旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node = RL_Rotate(node);
        }
        return node;
    }

    /**
     * 根据 Key 删除某条数据
     *
     * @param data
     * @return
     */
    @Override
    public V remove(K data) {
        V v = get(data);
        if (v == null) {
            return null;
        }
        root = remove(data, root);
        return v;

    }

    private Node remove(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(key, node.left);
        } else {
            if (node.left != null && node.right != null) {
                Node temp = max(node.left);
                node.key = temp.key;
                node.value = temp.value;

                node.left = remove(temp.key, node.left);
            } else {
                node = node.left == null ? node.right : node.left;
                size--;
            }
        }

        if (node == null) {
            return null;
        }
        // ============ 重点 =============
        // 对树进行回溯,如果树不平衡,将对树进行平衡操作

        // 重新计算高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balanceFactor = getBalanceFactor(node);

        // 如果该树的左子树不平衡,并且左子树的左边高与等于右边 进行LL旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            node = LL_Rotate(node);
        }

        // 如果该树的左子树不平衡,并且左子树的左边低于右边 进行LR旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node = LR_Rotate(node);
        }

        // 如果该树的右边不平衡,并且该右子树的的左边低于等于右边,进行RR旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            node = RR_Rotate(node);
        }

        // 如果该树的右边不平衡,并且该右子树的的左边高于右边,进行RL旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node = RL_Rotate(node);
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
        if (node == null) {
            return null;
        }
        return node.value;
    }


    private Node get(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return get(key, node.right);
        } else if (key.compareTo(node.key) < 0) {
            return get(key, node.left);
        }
        return node;
    }

    /**
     * 判断Key是否在当前容器里面
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return false;
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
     * 获取树高
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }


    private Node max(Node node) {
        if (node.right != null) {
            return max(node.right);
        }
        return node;
    }


    private Node min(Node node) {
        if (node.left != null) {
            return min(node.left);
        }
        return node;
    }

    private Node LL_Rotate(Node node) {
        Node newTree = node.left;
        node.left = newTree.right;
        newTree.right = node;

        // 重新计算树高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newTree.height = Math.max(getHeight(newTree.left), node.height) + 1;
        return newTree;

    }

    private Node RR_Rotate(Node node) {
        Node newTree = node.right;
        node.right = newTree.left;
        newTree.left = node;

        // 重新计算树高
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newTree.height = Math.max(getHeight(newTree.left), node.height) + 1;
        return newTree;
    }

    private Node LR_Rotate(Node node) {
        node.right = LL_Rotate(node.right);
        return RR_Rotate(node);
    }

    private Node RL_Rotate(Node node) {
        node.left = RR_Rotate(node.left);
        return LL_Rotate(node);
    }

    public static void main(String[] args) {
        AVLTree<Integer, String> tree = new AVLTree<>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        tree.put(4, "d");
        tree.put(5, "e");
        tree.put(6, "f");
        tree.put(7, "g");

        System.out.println();

        tree.remove(4);
        tree.remove(5);
        tree.remove(6);
        tree.remove(7);
        System.out.println();
    }
}
