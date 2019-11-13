package base;


/**
 * 单向链表
 *
 * @author joy
 * @time 2019/09/09 13:27
 */
public class Linked<E> implements Structure<E> {

    /**
     * 内部类 内部节点
     */
    private class Node {
        public E    data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private int  size;
    private Node dummyHeader;

    public Linked() {
        this.size = 0;
        this.dummyHeader = new Node();
    }





    /**
     * 加入尾节点
     *
     * @param data
     */
    public void addToLast(E data) {
        Node current = dummyHeader;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        size++;
    }

    /**
     * 加入头节点 (最快)
     *
     * @param data
     */
    @Override
    public void add(E data) {
        dummyHeader.next = new Node(data, dummyHeader.next);
        size++;
    }

    /**
     * 删除队首元素 (最快)
     *
     * @return
     */
    @Override
    public E remove() {
        if (size == 0) {
            throw new IllegalArgumentException("空链表");
        }
        Node head = dummyHeader.next;
        dummyHeader.next = head.next;
        size--;
        return head.data;
    }

    /**
     * 删除队尾元素
     *
     * @return
     */
    public E removeTail() {
        if (size == 0) {
            throw new IllegalArgumentException("空链表");
        }
        Node prev    = dummyHeader;
        Node current = dummyHeader;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        size--;
        return current.data;
    }


    public E getHead() {
        return dummyHeader.next == null ? null : dummyHeader.next.data;
    }

    public E getTail() {
        Node current = dummyHeader;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
    /**
     * 判断容器是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断元素是否包含在容器内
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean container(E data) {
        if (data == null) {
            throw new IllegalArgumentException("参数错误");
        }
        Node current = dummyHeader.next;
        while (current != null) {
            if (data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer str     = new StringBuffer("head : ");
        Node         current = dummyHeader.next;
        while (current != null) {
            str.append(current.data + " -> ");
            current = current.next;
        }
        str.append("tail size: " + size);
        return str.toString();
    }

    public static void main(String[] args) {
        Linked<Integer> linked = new Linked<>();
        for (int i = 0; i < 10; i++) {
            linked.addToLast(i);
            System.out.println(linked);
        }

        for (int i = 0; i < 10; i++) {
            linked.removeTail();
            System.out.println(linked);
        }
    }
}
