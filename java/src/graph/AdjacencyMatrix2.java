package graph;

import java.util.Iterator;

/**
 * 邻接矩阵
 * 适合表示稠密图 且只适合无向图
 */
public class AdjacencyMatrix2  {

    public int size = 0;
    public int total = 0;
    private boolean[] graph;


    public AdjacencyMatrix2(int total) {
        this.total = total;
        graph = new boolean[total * (total + 1) / 2];
    }

    /**
     * 两个顶点加入边
     *
     * @param i
     * @param j
     */
    public void insertEdge(int i, int j) {
        if (i < 0 || i >= total || j < 0 || j >= total) {
            throw new IllegalArgumentException("下标越界");
        }
        // 无法使用自环边
        if (i == j) {
            return;
        }
        if (hasEdge(i, j)) {
            return;
        }

        int index = getIndex(i, j);
        graph[index] = true;
        size++;

    }

    /**
     * 判断两个顶点是否有边
     *
     * @param i
     * @param j
     * @return
     */
    public boolean hasEdge(int i, int j) {
        if (i < 0 || i >= total || j < 0 || j >= total) {
            throw new IllegalArgumentException("下标越界");
        }
        return graph[getIndex(i, j)];
    }

    /**
     * @param i
     * @param j
     * @return
     */
    private int getIndex(int i, int j) {
        if (i < 0 || i >= total || j < 0 || j >= total) {
            throw new IllegalArgumentException("下标越界");
        }
        int max = Math.max(i, j);
        int min = Math.min(i, j);
        return max * (max + 1) / 2 + min;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < graph.length;
            }

            @Override
            public Object next() {
                return graph[cursor++];
            }
        };
    }

    /**
     * 获取顶点的个数
     *
     * @return
     */
    public int getVertexCount() {
        return total;
    }

    /**
     * 获取边的个数
     *
     * @return
     */
    public int getEdgeCount() {
        return size;
    }

    public static void main(String[] args) {
    }
}
