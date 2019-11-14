package tree;

/**
 * 线段树
 *
 * @author joy
 * @time 2019/11/13 16:43
 */
public class SegmentTree<E> {
    private Algorithm<E> algorithm;
    private E[]          tree;
    private E[]          data;

    public SegmentTree(E[] data, Algorithm<E> algorithm) {
        this.data = data.clone();
        this.algorithm = algorithm;
        tree = (E[]) new Object[4 * data.length];
        buildTree(0, 0, data.length - 1);
    }

    /**
     * 创建线段树
     *
     * @param index 所处节点的的索引
     * @param l     l-r 区间索引
     * @param r     l-r 区间索引
     */
    private void buildTree(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int mid        = (l + r) / 2;
        int leftIndex  = getLeft(index);
        int rightIndex = getRight(index);

        buildTree(leftIndex, l, mid);
        buildTree(rightIndex, mid + 1, r);
        tree[index] = algorithm.operation(tree[leftIndex], tree[rightIndex]);
    }

    /**
     * 查找 l - r 区间的值
     *
     * @param l
     * @param r
     * @return
     */
    public E query(int l, int r) {
        return query(0, 0, getSize() - 1, l, r);
    }

    private E query(int index, int l, int r, int queryLeft, int queryRight) {
        if (l == queryLeft && r == queryRight) {
            return tree[index];
        }

        int mid        = (l + r) / 2;
        int leftIndex  = getLeft(index);
        int rightIndex = getRight(index);

        // 如果要查找的区间起始点大于左孩子拥有的区间的结束位置，则只查右孩子
        if (queryLeft > mid) {
            return query(rightIndex, mid + 1, r, queryLeft, queryRight);
            // 如果要查找的区间的结束点小于右孩子拥有的区间的起始位置，则只查左孩子
        } else if (queryRight < mid + 1) {
            return query(leftIndex, l, mid, queryLeft, queryRight);
        }

        // 都有关系的话 边界需要改变
        E leftResult  = query(leftIndex, l, mid, queryLeft, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryRight);
        return algorithm.operation(leftResult, rightResult);

    }

    public void set(int index, E e) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("数组下标越界");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int index, int l, int r, int target, E e) {
        if (l == r) {
            tree[index] = e;
            return;
        }

        int mid        = l + (r - l) / 2;
        int leftChild  = getLeft(index);
        int rightChild = getRight(index);

        // 找右边
        if (target > mid) {
            set(rightChild, mid + 1, r, target, e);
        } else {
            // 找左边
            set(leftChild, l, mid, target, e);
        }

        tree[index] = algorithm.operation(tree[leftChild], tree[rightChild]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }

    public static void main(String[] args) {
        Integer[] ARR = new Integer[9];
        for (int i = 0; i < 9; i++) {
            ARR[i] = i;
        }
        SegmentTree<Integer> t = new SegmentTree<>(ARR, (a, b) -> a + b);
        int                  a = t.query(4, 7);
        System.out.println(a);
        System.out.println(t);
    }
}
