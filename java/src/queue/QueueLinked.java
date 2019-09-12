package queue;

import base.Linked;

/**
 * 队列 -- 单向链表实现
 *
 * @author joy
 * @time 2019/09/12 11:28
 */
public class QueueLinked<E> implements Queue<E> {

    private Linked<E> list = new Linked<>();

    /**
     * 入队
     * -- 加入链表头部 O(1)
     *
     * @param data
     */
    @Override
    public void enqueue(E data) {
        list.add(data);
    }

    /**
     * 出队
     * -- 删除链表尾部元素 O(n)
     *
     * @return
     */
    @Override
    public E dequeue() {
        return list.removeTail();
    }

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    /**
     * 获取下一个要出队的元素
     * -- 获取链表队尾元素 O(n)
     *
     * @return
     */
    @Override
    public E getNext() {
        return list.getTail();
    }

    /**
     * 当前队列容量
     *
     * @return int
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        QueueLinked<Integer> queue = new QueueLinked<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.getNext());
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
