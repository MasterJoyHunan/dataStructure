package map;

import base.AVLTree;

public class AvlTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> data = new AVLTree<>();

    /**
     * 插入/修改 数据
     *
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        data.put(key, value);
    }

    /**
     * 根据Key 删除某条数据
     *
     * @param data
     * @return
     */
    @Override
    public V remove(K data) {
        return this.data.remove(data);
    }

    /**
     * 根据Key获取某条数据
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return data.get(key);
    }

    /**
     * 判断Key是否在当前容器里面
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(K key) {
        return data.contains(key);
    }

    /**
     * 判断容器是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取当前容器元素的个数
     *
     * @return
     */
    @Override
    public int getSize() {
        return data.getSize();
    }
}
