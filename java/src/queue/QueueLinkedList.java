package queue;

import base.LinkedList;

/**
 * 队列 -- 双向链表实现
 *
 * @author joy
 * @time 2019/09/12 12:32
 */
public class QueueLinkedList<E> implements Queue<E> {

    LinkedList<E> list = new LinkedList<>();

    /**
     * 入队
     * -- 加入链表头 O(1)
     *
     * @param data E
     */
    @Override
    public void enqueue(E data) {
        list.add(data);
    }

    /**
     * 出队
     * -- 删除队尾元素 O(1)
     *
     * @return E
     */
    @Override
    public E dequeue() {
        return list.removeTail();
    }

    /**
     * 获取下一个出队的元素
     * -- 查看队尾元素 O(1)
     *
     * @return E
     */
    @Override
    public E getNext() {
        return list.getTail();
    }

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 当前队列容量
     *
     * @return int
     */
    @Override
    public int getSize() {
        return 0;
    }


    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
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
