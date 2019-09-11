package base;

/**
 * 循环数组
 *
 * @author joy
 * @time 2019/09/09 13:26
 */
public class LoopArrayList<E> {

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
     * 插入到索引为tail的位置
     *
     * @param data
     */
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
     * 删除索引为front位置的元素
     *
     * @return E
     */
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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == front;
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
