package stack;

import base.ArrayList;

/**
 * 数组堆栈
 *
 * @author joy
 * @time 2019/09/11 19:22
 */
public class StackArray<E> implements Stack<E> {

    private ArrayList<E> list;

    public StackArray() {
        this.list = new ArrayList<>();
    }

    /**
     * 入栈
     * -- 插入元素到数组最后索引 O(1)
     *
     * @param data
     */
    @Override
    public void push(E data) {
        list.add(data);
    }

    /**
     * 出栈
     * -- 删除数组最后索引的元素 O(1)
     *
     * @return
     */
    @Override
    public E pop() {
        return list.removeByIndex(list.getSize() - 1);
    }

    /**
     * 查看栈顶元素
     * -- 根据索引查找元素 O(1)
     *
     * @return
     */
    @Override
    public E peek() {
        return list.getValue(list.getSize() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
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
