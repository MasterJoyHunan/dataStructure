package queue;

/**
 * 队列抽象接口
 *
 * @author joy
 * @time 2019/09/11 20:07
 */
public interface Queue<E> {

    /**
     * 入队
     *
     * @param data E
     */
    void enqueue(E data);

    /**
     * 出队
     *
     * @return E
     */
    E dequeue();

    /**
     * 获取下一个出队的元素
     *
     * @return E
     */
    E getNext();

    /**
     * 队列是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 当前队列容量
     *
     * @return int
     */
    int getSize();

}
