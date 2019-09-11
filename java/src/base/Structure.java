package base;

/**
 * @author joy
 * @time 2019/09/09 15:45
 */
public interface Structure <E>{
    void add(E data);
    E remove(E data);
    int getSize();
    boolean isEmpty();
}
