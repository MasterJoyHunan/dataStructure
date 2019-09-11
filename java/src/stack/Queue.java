package stack;

/**
 * @author joy
 * @time 2019/09/11 20:07
 */
public interface Queue<E> {

    void enqueue(E data);
    E dequeue();
    boolean isEmpty();
}
