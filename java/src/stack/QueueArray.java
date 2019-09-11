package stack;

import base.ArrayList;

/**
 * 数组队列
 *
 * @author joy
 * @time 2019/09/11 19:22
 */
public class QueueArray<E> implements Queue<E> {
    private ArrayList<E> queue;

    public QueueArray() {
        this.queue = new ArrayList<>();
    }

    /**
     * 入队
     * 加入队头 O(n)
     *
     * @param data
     */
    @Override
    public void enqueue(E data) {
        queue.addFirst(data);
    }

    /**
     * 出队
     * 加入队尾 O(1)
     *
     * @return
     */
    @Override
    public E dequeue() {
        return queue.removeByIndex(queue.getSize() - 1);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public E getNext() {
        return queue.getValue(queue.getSize() - 1);
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        QueueArray<Integer> queue = new QueueArray<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 10; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
