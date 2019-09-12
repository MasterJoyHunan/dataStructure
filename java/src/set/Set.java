package set;

/**
 * 集合
 *
 * @author joy
 * @time 2019/09/12 12:40
 */
public interface Set<E extends Comparable<E>> {

    /**
     * 往集合添加元素
     *
     * @param data E
     */
    void add(E data);

    /**
     * 删除集合中含有该元素的数据
     *
     * @param data E
     * @return E
     */
    E remove(E data);

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 查看集合中元素的个数
     *
     * @return int
     */
    int getSize();
}
