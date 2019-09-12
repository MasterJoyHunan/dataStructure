package base;

/**
 * 循环数组
 *
 * @author joy
 * @time 2019/09/09 13:26
 */
public class LoopArrayList<E> implements Structure<E> {

    private int front;
    private int tail;
    private int size;
    private int capacity;
    private E[] data;

    public LoopArrayList(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
        this.data = (E[]) new Object[capacity];
    }

    public LoopArrayList() {
        this(5);
    }


    /**
     * 插入到队尾
     * -- 删除数组尾节点
     *
     * @param data
     */
    @Override
    public void add(E data) {
        // 相当于 (tail + 1) % capacity == front
        if (capacity - 1 == size) {
            resize(capacity * 2);
        }
        this.data[tail] = data;
        tail = (tail + 1) % capacity;
        size++;
    }

    /**
     * 删除元素
     * -- 删除数组头节点
     *
     * @return E
     */
    @Override
    public E remove() {
        if (size == 0) {
            throw new IllegalArgumentException("空数据");
        }
        E data = this.data[front];
        this.data[front] = null;
        size--;
        front = (front + 1) % capacity;
        if (size == (capacity / 4) && capacity != 0) {
            resize(capacity / 2);
        }
        return data;
    }

    public E getHead() {
        return data[front];
    }

    public E getLast() {
        return data[(tail - 1) % capacity];
    }

    /**
     * 删除最后进入的元素
     *
     * @return
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        int index = (tail - 1) % capacity;
        E   temp  = data[index];
        data[index] = null;
        tail = index;
        size--;
        if (size == (capacity / 4) && capacity != 0) {
            resize(capacity / 2);
        }
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean container(E data) {
        if (data == null) {
            throw new IllegalArgumentException("非法参数");
        }
        for (int i = 0; i < size; i++) {
            if (data.equals(this.data[(front + 0) % capacity])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("front -> ");
        for (E e : data) {
            if (e == null) {
                continue;
            }
            stringBuffer.append(e + " -> ");
        }
        stringBuffer.append("tail size:" + size + " capacity:" + capacity);
        return stringBuffer.toString();
    }

    /**
     * 重新分配空间
     *
     * @param capacity
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        int j       = 0;
        for (int i = 0; i < size; i++) {
            newData[j] = data[(front + i) % this.capacity];
            j++;
        }
        this.data = newData;
        this.capacity = capacity;
        front = 0;
        tail = size;
    }

    public static void main(String[] args) {
        LoopArrayList<Integer> list = new LoopArrayList<>();
        System.out.println(list);
        for (int i = 0; i < 20; i++) {
            list.add(i);
            System.out.println(list);
            if (i % 5 == 1) {
                list.remove();
                System.out.println(list);
            }
        }
        for (int i = 0; i < 20; i++) {
            list.remove();
            System.out.println(list);
        }
    }
}
