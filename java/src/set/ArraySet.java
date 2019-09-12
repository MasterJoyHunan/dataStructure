package set;

import base.ArrayList;

/**
 * 集合 -- 动态数组实现
 *
 * @author joy
 * @time 2019/09/12 13:51
 */
public class ArraySet<E extends Comparable<E>> implements Set<E> {

    private ArrayList<E> arr = new ArrayList<>();

    /**
     * 往集合添加元素
     * -- 需要判断是否在数组中 O(n)
     *
     * @param data E
     */
    @Override
    public void add(E data) {
        if (!arr.container(data)) {
            arr.add(data);
        }
    }

    /**
     * 删除集合中含有该元素的数据
     * -- 需要查找才能删除 O(n)
     *
     * @param data E
     * @return E
     */
    @Override
    public E remove(E data) {
        return arr.remove(data);
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    /**
     * 查看集合中元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return arr.getSize();
    }
}
