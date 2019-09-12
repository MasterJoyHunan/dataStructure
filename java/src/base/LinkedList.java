package base;

/**
 * 双向链表
 *
 * @author joy
 * @time 2019/09/09 15:44
 */
public class LinkedList<E> implements Structure<E> {

    private class Node {
        private E    data;
        private Node pre;
        private Node next;

        private Node(E data) {
            this.data = data;
            this.pre = null;
            this.next = null;
        }
    }


    /**
     * 虚拟节点 (哨兵节点)
     * next => 头节点
     * pre => 尾节点
     */
    private Node dummyHeader;
    private int  size;

    public LinkedList() {
        this.dummyHeader = new Node(null);
        this.dummyHeader.next = this.dummyHeader;
        this.dummyHeader.pre = this.dummyHeader;
    }

    /**
     * 添加至队首
     *
     * @param data
     */
    @Override
    public void add(E data) {
        if (data == null) {
            throw new IllegalArgumentException("非法参数");
        }

        Node node = new Node(data);
        node.pre = dummyHeader;
        node.next = dummyHeader.next;

        // 重设头结点, 尾节点
        dummyHeader.next.pre = node;
        dummyHeader.next = node;
        if (size == 0) {
            dummyHeader.pre = node;
        }
        size++;
    }

    /**
     * 根据传过来的数据删除节点 O(n)
     *
     * @param data
     * @return
     */
    public E remove(E data) {
        if (data == null) {
            throw new IllegalArgumentException("非法参数");
        }
        Node current = dummyHeader.next;
        while (current != null && current != dummyHeader) {
            if (current.data.equals(data)) {
                return remove(current);
            }
            current = current.next;
        }
        throw new IllegalArgumentException("数据不存在");
    }

    /**
     * 删除头节点 时间复杂度O(1)
     *
     * @return E
     */
    @Override
    public E remove() {
        return remove(dummyHeader.next);
    }

    /**
     * 删除尾节点 时间复杂度O(1)
     *
     * @return E
     */
    public E removeTail() {
        return remove(dummyHeader.pre);
    }

    /**
     * 删除数据
     *
     * @param node
     * @return E
     */
    private E remove(Node node) {
        if (size == 0) {
            throw new IllegalArgumentException("空结构");
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
        size--;
        return node.data;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean container(E data) {
        if (data == null) {
            throw new IllegalArgumentException("非法参数");
        }
        Node current = dummyHeader.next;
        while (current != null && current != dummyHeader) {
            if (data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E getHead() {
        return dummyHeader.next == null ? null : dummyHeader.next.data;

    }

    public E getTail() {
        return dummyHeader.next == null ? null : dummyHeader.pre.data;
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("head -> ");
        Node         current      = dummyHeader.next;
        while (current != null && current != dummyHeader) {
            stringBuffer.append(current.data + " -> ");
            current = current.next;
        }
        stringBuffer.append("tail; size = " + size);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println(list);
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println(list);
        }

        System.out.println(list.getHead());
        System.out.println(list.getTail());

        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            list.remove();
            System.out.println(list);
        }
        System.out.println(list);
    }
}
