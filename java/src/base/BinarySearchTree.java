package base;

/**
 * 二叉搜索树
 *
 * @author joy
 * @time 2019/09/09 13:28
 */
public class BinarySearchTree<E extends Comparable<E>> implements Structure<E> {

    private class Node {
        private E    data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
        }
    }


    private Node root;
    private int  size;

    @Override
    public void add(E data) {
        root = add(root, data);
    }

    /**
     * 递归添加 比较左右两边大小
     *
     * @param node
     * @param data
     * @return
     */
    private Node add(Node node, E data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        if (data.compareTo(node.data) > 0) {
            node.right = add(node.right, data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = add(node.left, data);
        }
        return node;
    }

    @Override
    public E remove(E data) {
        if (root == null) {
            throw new IllegalArgumentException("数据为空");
        }
        root = remove(root, data);
        return data;
    }

    /**
     * 要删除, 先查找,查找到对应的节点,判断左右子树是否为空,
     * 如都不空则需要(删除左子树里最大值/右子树里最小值)
     *
     * @param node
     * @param data
     * @return
     */
    private Node remove(Node node, E data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) > 0) {
            node.right = remove(node.right, data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = remove(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                Node temp = max(node.left);
                node.data = temp.data;
                node.left = remove(node.left, temp.data);
            } else {
                node = node.left != null ? node.left : node.right;
                size--;
            }
        }
        return node;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public E max() {
        if (root == null) {
            throw new IllegalArgumentException("数据为空");
        }
        return max(root).data;
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
    public E min() {
        if (root == null) {
            throw new IllegalArgumentException("数据为空");
        }
        return min(root).data;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(11);
        bst.add(2);
        bst.add(3);
        bst.add(11);
        bst.add(8);
        bst.add(6);

        bst.remove(5);
        bst.remove(11);
        bst.remove(2);
        bst.remove(3);
        bst.remove(8);
        bst.remove(6);
        bst.remove(6);
        System.out.println(bst);
    }
}
