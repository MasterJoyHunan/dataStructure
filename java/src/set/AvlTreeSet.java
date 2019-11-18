package set;

import base.AVLTree;

public class AvlTreeSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> data = new AVLTree<>();

    /**
     * 往集合添加元素
     *
     * @param data E
     */
    @Override
    public void add(E data) {
        this.data.put(data, null);
    }

    /**
     * 删除集合中含有该元素的数据
     *
     * @param data E
     * @return E
     */
    @Override
    public E remove(E data) {
        if (this.data.remove(data) == null) {
            return null;
        }
        return data;
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 查看集合中元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return data.getSize();
    }
}
