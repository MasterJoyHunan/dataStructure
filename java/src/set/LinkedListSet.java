package set;

import base.LinkedList;

/**
 * 集合 -- 链表实现
 *
 * @author joy
 * @time 2019/09/12 15:09
 */
public class LinkedListSet<E extends Comparable<E>> implements Set<E> {

    LinkedList<E> list = new LinkedList<>();

    /**
     * 往集合添加元素
     * -- O(n)
     *
     * @param data E
     */
    @Override
    public void add(E data) {
        if (!list.container(data)) {
            list.add(data);
        }
    }

    /**
     * 删除集合中含有该元素的数据
     * -- O(n)
     *
     * @param data E
     * @return E
     */
    @Override
    public E remove(E data) {
        return list.remove(data);
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 查看集合中元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return list.getSize();
    }
}
