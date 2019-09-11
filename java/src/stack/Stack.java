package stack;

/**
 * @author joy
 * @time 2019/09/11 19:23
 */
interface Stack<E> {

    void push(E data);
    E pop();
    E peek();
    boolean isEmpty();
}
