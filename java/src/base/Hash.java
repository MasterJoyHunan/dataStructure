package base;

import java.util.TreeMap;

import java.util.Map;

public class Hash<K extends Comparable<K>, V> {

    /**
     * size / M >= UPPER_TOLERATE
     * 如果平均每个下标元素里含有11个元素，则需要扩容了
     */
    private static final int UPPER_TOLERATE = 11;

    /**
     * size / M <= LOWER_TOLERATE
     * 如果平均每个下标里含有少于2个元素，则需要缩容
     */
    private static final int LOWER_TOLERATE = 2;

    /**
     * 对素数进行取余比较平均
     */
    private static final int[] CAPACITY = new int[]{
            53,
            97,
            193,
            389,
            769,
            1543,
            3079,
            6151,
            12289,
            24593,
            49157,
            98317,
            196613,
            393241,
            786433,
            1572869,
            3145739,
            6291469,
            12582917,
            25165843,
            50331653,
            100663319,
            201326611,
            402653189,
            805306457,
            1610612741,
    };

    /**
     * 初始容量下标
     */
    private int capacityIndex = 0;


    private TreeMap<K, V>[] data;

    private int M;

    private int size = 0;

    public Hash() {
        data = new TreeMap[CAPACITY[capacityIndex]];
        for (int i = 0; i < CAPACITY[capacityIndex]; i++) {
            data[i] = new TreeMap<>();
        }
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int hash = hash(key);
        TreeMap<K, V> temp = data[hash];
        if (!temp.containsKey(key)) {
            size++;
            if (size / M >= UPPER_TOLERATE && capacityIndex + 1 < CAPACITY.length) {
                capacityIndex++;
                resize(CAPACITY[capacityIndex]);
            }
        }
        temp.put(key, value);
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    public V remove(K key) {
        int hash = hash(key);
        TreeMap<K, V> temp = data[hash];
        if (temp == null) {
            return null;
        }
        V value = temp.remove(key);
        if (value == null) {
            return null;
        }
        size--;
        if (size / M <= LOWER_TOLERATE && capacityIndex - 1 >= 0) {
            capacityIndex--;
            resize(CAPACITY[capacityIndex]);
        }
        return value;
    }


    private void resize(int capacity) {
        TreeMap<K, V>[] newData = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newData[i] = new TreeMap<>();
        }
        int oldM = M;
        M = capacity;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> temp = data[i];
            for (Map.Entry<K, V> enter : temp.entrySet()) {
                newData[hash(enter.getKey())].put(enter.getKey(), enter.getValue());
            }
        }
        data = newData;
    }


    @Override
    public int hashCode() {
        // ((((0 * B) + a) * B + b) * B + c) % M
        // ((((0 * B) + a) % M * B + b) % M * B + c) % M
        int B = 31;
        int hash = 0;
        hash = (hash * B + size) % M;
        hash = (hash * B + data.hashCode()) % M;
        return hash;
    }
}
