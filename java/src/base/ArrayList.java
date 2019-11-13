package base;

/**
 * 动态数组
 * 可以动态扩容的数组
 *
 * @author joy
 * @time 2019/09/09 13:25
 */
public class ArrayList<E> implements Structure<E> {
    private int capacity;
    private int size;
    private E[] data;

    public ArrayList() {
        this(10);
    }

    /**
     * 设置初始容量
     *
     * @param capacity
     */
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity + 1];
        this.size = 0;
    }


    /**
     * 添加
     * -- 加入数组的尾
     *
     * @param value
     */
    @Override
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("非法参数");
        }
        if (size == capacity) {
            resize(capacity * 2);
        }
        addByIndex(size, value);
    }


    /**
     * 加入到数组头部
     *
     * @param value
     */
    public void addFirst(E value) {
        addByIndex(0, value);
    }


    /**
     * 加入指定的位置
     *
     * @param index
     * @param value
     */
    public void addByIndex(int index, E value) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }


    /**
     * 根据值获取对应的索引
     *
     * @param value
     * @return
     */
    public int getIndex(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据索引获得对应的值
     *
     * @param index
     * @return
     */
    public E getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标越界");
        }
        return data[index];
    }


    /**
     * 默认删除
     * -- 删除数组最后一个元素
     *
     * @return E
     */
    @Override
    public E remove() {
        if (size == 0) {
            return null;
        }
        return removeByIndex(size - 1);
    }


    /**
     * 根据值来删除数据
     *
     * @param value
     * @return
     */
    public E remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException("非法参数");
        }
        int index = getIndex(value);
        if (index != -1) {
            removeByIndex(index);
            return value;
        }
        throw new IllegalArgumentException("不存在该数据");
    }


    /**
     * 根据索引
     *
     * @param index
     * @return
     */
    public E removeByIndex(int index) {
        E temp = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size == capacity / 4 && size != 0) {
            resize(capacity / 2);
        }
        return temp;
    }

    /**
     * 交换两个值
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("下标错误");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean container(E data) {
        return getIndex(data) != -1;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * 重新分配空间
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        this.capacity = newCapacity;
        this.data = newData;
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Array : ");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(" [" + i + "]" + "=>" + data[i] + ",");
        }
        stringBuffer.append(" size : " + getSize() + " capacity : " + capacity);
        return stringBuffer.toString();
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(5);
        for (int i = 1; i < 12; i++) {
            arr.add(i);
            System.out.println(arr);
        }
        for (int i = 1; i < 12; i++) {
            arr.remove(i);
            System.out.println(arr);
        }
    }
}
