package graph;

import java.util.*;

/**
 * 邻接矩阵
 * 适合表示稠密图
 */
public class AdjacencyMatrix implements Graph {

    public int size = 0;
    public int total = 0;
    private boolean[][] graph;
    private boolean directed = false;

    public AdjacencyMatrix(int total) {
        this(total, false);
    }

    public AdjacencyMatrix(int total, boolean directed) {
        this.directed = directed;
        this.total = total;
        graph = new boolean[total][total];
    }

    /**
     * 两个顶点加入边
     *
     * @param i
     * @param j
     */
    @Override
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

        graph[i][j] = true;

        // 无向图两边都加边
        if (!directed) {
            graph[j][i] = true;
        }
        size++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<boolean[]> iterator() {
        return new Iterator<>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != total;
            }

            @Override
            public boolean[] next() {
                return graph[cursor++];
            }
        };
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
        return graph[i][j];
    }

    /**
     * 获取顶点的个数
     *
     * @return
     */
    @Override
    public int getVertexCount() {
        return total;
    }

    /**
     * 获取边的个数
     *
     * @return
     */
    @Override
    public int getEdgeCount() {
        return size;
    }

    /**
     * 循环
     *
     * @param i
     * @return
     */
    @Override
    public List<Integer> getAdjacency(int i) {
        return new ArrayList(Collections.singleton(graph[i]));
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(9);
        Random R = new Random();
        for (int i = 0; i < 20; i++) {
            graph.insertEdge(R.nextInt(8), R.nextInt(8));
        }
        Iterator it = graph.iterator();
        while (it.hasNext()) {
            boolean[] temp = (boolean[]) it.next();
            for (int i = 0; i < temp.length; i++) {
                System.out.print((temp[i] ? 1 : 0 )+ " ");
            }
            System.out.println();
        }
    }
}
