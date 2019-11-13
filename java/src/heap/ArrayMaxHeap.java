package heap;

import base.ArrayList;

import java.util.Random;

/**
 * 数组实现最大堆
 *
 * @author joy
 * @time 2019/11/13 11:56
 */
public class ArrayMaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public ArrayMaxHeap() {
        this.data = new ArrayList<>();
    }

    public ArrayMaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    /**
     * 获取根节点
     *
     * @return
     */
    public E getTop() {
        return data.getValue(0);
    }


    /**
     * 获取父节点
     *
     * @return
     */
    private int getParent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 not parent");
        }
        return (index - 1) / 2;
    }


    /**
     * 获取左节点
     *
     * @return
     */
    private int getLeft(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取右节点
     *
     * @return
     */
    private int getRight(int index) {
        return index * 2 + 2;
    }


    /**
     * 向堆中添加元素
     *
     * @param e
     */
    public void add(E e) {
        data.add(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 数据上浮
     *
     * @param index
     */
    private void siftUp(int index) {
        while (index != 0 && data.getValue(index).compareTo(data.getValue(getParent(index))) > 0) {
            data.swap(index, getParent(index));
            siftUp(getParent(index));
        }
    }

    /**
     * 获取堆中最大元素
     *
     * @return
     */
    public E getMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆中无元素");
        }
        return data.getValue(0);
    }

    /**
     * 提取堆中最大元素
     *
     * @return
     */
    public E extactMax() {
        E res = getMax();
        // 获取最后一个元素
        if (data.getSize() == 0) {
            data.remove();
            return res;
        }
        data.remove();
        siftDown(0);
        return res;
    }

    /**
     * 数据下沉
     *
     * @param index
     */
    private void siftDown(int index) {
        // 在有左孩子的情况下才进行操作
        while (getLeft(index) < data.getSize()) {
            int max = getLeft(index);
            // 如果有右孩子，并且右孩子比左孩子大的话，设置最大的index为右孩子的index
            if (getRight(index) < data.getSize() && data.getValue(getRight(index)).compareTo(data.getValue(max)) > 0) {
                max = getRight(index);
            }
            // 如果当前节点和左右孩子最大的那个节点大，说明到位了，可退出
            if (data.getValue(index).compareTo(data.getValue(max)) >= 0) {
                break;
            }
            data.swap(index, max);
            index = max;
        }
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < data.getSize(); i++) {
            str.append( i + " => " + data.getValue(i) + "\n");
        }
        return str.toString();

    }

    public static void main(String[] args) {
        ArrayMaxHeap<Integer> heap = new ArrayMaxHeap<>();
        for (int i = 0; i < 100 ; i++) {
            heap.add(new Random().nextInt());
        }
        System.out.println(heap);
    }

}
