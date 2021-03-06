package stack;

import base.ArrayList;

/**
 * 堆栈 -- 动态数组实现
 *
 * @author joy
 * @time 2019/09/11 19:22
 */
public class StackArray<E> implements Stack<E> {

    private ArrayList<E> list = new ArrayList<>();

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
        return list.removeByIndex(list.getSize() - 1);
    }

    /**
     * 获取栈顶元素
     * -- 根据索引查找元素 O(1)
     *
     * @return E
     */
    @Override
    public E peek() {
        return list.getValue(list.getSize() - 1);
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
        StackArray<Integer> stack = new StackArray<>();
        System.out.println(stack);

        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        for (int i = 0; i < 10; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }
}
