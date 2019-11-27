package graph;

import java.util.*;

/**
 * 邻接表
 * 适合表示稀疏图
 */
public class AdjacencyList implements Graph {
    /**
     * 图里含有多少条边
     */
    private int size = 0;

    /**
     * 图里多少个顶点
     */
    private int total = 0;


    /**
     * 如果含有平行边使用 list 不包含平行边使用 set
     */
    private List[] graph;

    /**
     * 是否是有向边
     */
    private boolean directed = false;


    public AdjacencyList(int total) {
        this(total, false);
    }


    public AdjacencyList(int total, boolean directed) {
        this.directed = directed;
        this.total = total;
        graph = new List[total];
        for (int i = 0; i < total; i++) {
            graph[i] = new ArrayList();
        }
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
        graph[i].add(j);

        // 无向图给对方也添加自己
        if (!directed) {
            graph[j].add(i);
        }
        size++;
    }

    /**
     * 判断两个顶点是否有边
     *
     * @param i
     * @param j
     * @return
     */
    @Override
    public boolean hasEdge(int i, int j) {
        if (i < 0 || i >= total || j < 0 || j >= total) {
            throw new IllegalArgumentException("下标越界");
        }
        return graph[i].contains(j);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Collection> iterator() {
        return new Iterator<>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != graph.length;
            }

            @Override
            public Collection next() {
                return graph[cursor++];
            }
        };
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


    @Override
    public List<Integer> getAdjacency(int i) {
        return graph[i];
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

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(9);
        Random R = new Random();
        for (int i = 0; i < 10; i++) {
            graph.insertEdge(R.nextInt(9), R.nextInt(9));
        }
        Iterator it = graph.iterator();
        for (int i = 0; it.hasNext(); ) {
            System.out.println(i + " => " + it.next());
            i++;
        }
    }
}
