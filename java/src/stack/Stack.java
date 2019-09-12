package stack;

/**
 * 堆栈接口
 *
 * @author joy
 * @time 2019/09/11 19:23
 */
interface Stack<E> {
    /**
     * 加入堆栈
     *
     * @param data E
     */
    void push(E data);

    /**
     * 弹出堆栈
     *
     * @return E
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return E
     */
    E peek();

    /**
     * 获取堆栈容量
     *
     * @return int
     */
    int getSize();

    /**
     * 判断堆栈是否为空
     *
     * @return boolean
     */
    boolean isEmpty();
}
