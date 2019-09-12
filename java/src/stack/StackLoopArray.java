package stack;

import base.LoopArrayList;

/**
 * 堆栈 -- 循环数组实现
 *
 * @author joy
 * @time 2019/09/12 08:40
 */
public class StackLoopArray<E> implements Stack<E> {

    private LoopArrayList<E> list = new LoopArrayList<>();

    /**
     * 加入堆栈
     * -- 插入元素到数组最后索引 O(1)
     *
     * @param data E
     */
    @Override
    public void push(E data) {
        list.add(data);
    }

    /**
     * 弹出堆栈
     * -- 删除数组最后索引的元素 O(1)
     *
     * @return E
     */
    @Override
    public E pop() {
        return list.removeLast();
    }

    /**
     * 获取栈顶元素
     * -- 根据索引查找元素 O(1)
     *
     * @return E
     */
    @Override
    public E peek() {
        return list.getLast();
    }

    /**
     * 判断堆栈是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 获取堆栈容量
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
        StackLoopArray<Integer> list = new StackLoopArray<>();
        for (int i = 0; i < 10; i++) {
            list.push(i);
            System.out.println(list);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(list.peek());
            list.pop();
            System.out.println(list);
        }
    }
}
