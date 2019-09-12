package queue;

import base.LoopArrayList;

/**
 * 列队 -- 循环数组实现
 *
 * @author joy
 * @time 2019/09/12 09:36
 */
public class QueueLoopArray<E> implements Queue<E> {

    private LoopArrayList<E> list = new LoopArrayList<>();

    /**
     * 入队
     * -- 插入循环数组的尾 O(1)
     *
     * @param data
     */
    @Override
    public void enqueue(E data) {
        list.add(data);
    }

    /**
     * 出队
     * -- 删除循环数组的头 O(1)
     *
     * @return
     */
    @Override
    public E dequeue() {
        return list.remove();
    }

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 获取下一个要弹出的元素
     * -- 查询循环数组队头的元素 O(1)
     *
     * @return
     */
    @Override
    public E getNext() {
        return list.getHead();
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
        QueueLoopArray<Integer> queue = new QueueLoopArray<>();
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
