package queue;

import base.ArrayList;

/**
 * 队列 -- 数组实现
 *
 * @author joy
 * @time 2019/09/11 19:22
 */
public class QueueArray<E> implements Queue<E> {

    private ArrayList<E> queue = new ArrayList<>();

    /**
     * 入队
     * -- 加入数组队头 O(n)
     *
     * @param data
     */
    @Override
    public void enqueue(E data) {
        queue.addFirst(data);
    }

    /**
     * 出队
     * -- 删除数组尾元素 O(1)
     *
     * @return
     */
    @Override
    public E dequeue() {
        return queue.removeByIndex(queue.getSize() - 1);
    }

    /**
     * 获取下一个出队的元素
     * -- 获取数组尾的元素 O(1)
     *
     * @return E
     */
    @Override
    public E getNext() {
        return queue.getValue(queue.getSize() - 1);
    }

    /**
     * 当前队列容量
     *
     * @return int
     */
    @Override
    public int getSize() {
        return queue.getSize();
    }

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
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
