package map;

/**
 * 映射
 *
 * @author joy
 * @time 2019/09/12 15:12
 */
public interface Map<K, V> {

    /**
     * 插入/修改 数据
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * 根据Key 删除某条数据
     *
     * @param data
     * @return
     */
    V remove(K data);

    /**
     * 根据Key获取某条数据
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 判断Key是否在当前容器里面
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 判断容器是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 获取当前容器元素的个数
     *
     * @return
     */
    int getSize();
}
