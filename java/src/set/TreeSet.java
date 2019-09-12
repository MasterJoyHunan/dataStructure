package set;

import base.BinarySearchTree;

/**
 * 集合 -- BST实现
 *
 * @author joy
 * @time 2019/09/12 13:38
 */
public class TreeSet<E extends Comparable<E>> implements Set<E> {

    BinarySearchTree<E> bst = new BinarySearchTree<>();

    /**
     * 往集合添加元素
     * -- 二叉树添加 O(logn)
     *
     * @param data E
     */
    @Override
    public void add(E data) {
        bst.add(data);
    }

    /**
     * 删除集合中含有该元素的数据
     * -- 二叉树删除 log(n)
     *
     * @param data E
     * @return E
     */
    @Override
    public E remove(E data) {
        return bst.remove(data);
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    /**
     * 查看集合中元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return bst.getSize();
    }


    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println(set.getSize());
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println(set.getSize());
    }
}
