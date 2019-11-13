package queue;

import base.MaxHeap;

/**
 * 优先队列
 *
 * @author joy
 * @time 2019/11/13 15:32
 */
public class PrioirtyQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> data = new MaxHeap<>();

    /**
     * 入队
     *
     * @param data E
     */
    @Override
    public void enqueue(E data) {
        this.data.add(data);
    }

    /**
     * 出队
     *
     * @return E
     */
    @Override
    public E dequeue() {
        return data.extactMax();
    }

    /**
     * 获取下一个出队的元素
     *
     * @return E
     */
    @Override
    public E getNext() {
        return data.getTop();
    }

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 当前队列容量
     *
     * @return int
     */
    @Override
    public int getSize() {
        return data.getSize();
    }
}
