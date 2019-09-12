package map;

/**
 * @author joy
 * @time 2019/09/12 15:20
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        private K    key;
        private V    value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 插入/修改 数据
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {

    }

    /**
     * 根据Key 删除某条数据
     *
     * @param data
     * @return
     */
    @Override
    public V remove(K data) {
        return null;
    }

    /**
     * 根据Key获取某条数据
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return null;
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
        return false;
    }

    /**
     * 获取当前容器元素的个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }
}
