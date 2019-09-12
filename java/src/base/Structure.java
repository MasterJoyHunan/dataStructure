package base;

/**
 * @author joy
 * @time 2019/09/09 15:45
 */
public interface Structure<E> {
    /**
     * 插入
     *
     * @param data E
     */
    void add(E data);

    /**
     * 删除
     *
     * @return E
     */
    E remove();

    /**
     * 获取容器内元素的个数
     *
     * @return int
     */
    int getSize();

    /**
     * 判断容器是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 判断元素是否包含在容器内
     *
     * @return boolean
     */
    boolean container(E data);
}
