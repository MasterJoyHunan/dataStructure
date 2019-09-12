package stack;

import base.LinkedList;

/**
 * 堆栈 -- 双向链表实现
 *
 * @author joy
 * @time 2019/09/12 09:21
 */
public class StackLinkedList<E> implements Stack<E> {

    private LinkedList<E> list = new LinkedList<>();

    /**
     * 加入堆栈
     * -- 插入元素到链表头 O(1)
     *
     * @param data E
     */
    @Override
    public void push(E data) {
        list.add(data);
    }

    /**
     * 弹出堆栈
     * -- 删除链表头的元素 O(1)
     *
     * @return E
     */
    @Override
    public E pop() {
        return list.remove();
    }

    /**
     * 获取栈顶元素
     * -- 查找链表头的元素 O(1)
     *
     * @return E
     */
    @Override
    public E peek() {
        return list.getHead();
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
        return 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }


    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.peek());
            stack.pop();
            System.out.println(stack);
        }
    }
}
