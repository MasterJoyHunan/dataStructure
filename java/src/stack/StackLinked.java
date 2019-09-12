package stack;

import base.Linked;

/**
 * 堆栈 --单向链表实现
 *
 * @author joy
 * @time 2019/09/12 08:27
 */
public class StackLinked<E> implements Stack<E> {

    private Linked<E> list = new Linked<>();

    /**
     * 加入堆栈
     * -- 加入到单向链表的头节点 O(1)
     *
     * @param data
     */
    @Override
    public void push(E data) {
        list.add(data);
    }

    /**
     * 弹出堆栈
     * -- 删除单向链表头节点 O(1)
     *
     * @return
     */
    @Override
    public E pop() {
        return list.remove();
    }

    /**
     * 获取栈顶元素
     * -- 获取链表头结点 O(1)
     *
     * @return
     */
    @Override
    public E peek() {
        return list.getHead();
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
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }


    public static void main(String[] args) {
        StackLinked<Integer> stack = new StackLinked<>();
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
