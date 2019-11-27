package graph;

import java.util.Collection;
import java.util.List;

public interface Graph extends Iterable {

    /**
     * 两个顶点加入边
     *
     * @param i
     * @param j
     */
    void insertEdge(int i, int j);

    /**
     * 判断两个顶点是否有边
     *
     * @param i
     * @param j
     * @return
     */
    boolean hasEdge(int i, int j);


    /**
     * 获取顶点的个数
     *
     * @return
     */
    int getVertexCount();


    /**
     * 获取边的个数
     *
     * @return
     */
    int getEdgeCount();


    /**
     * 循环
     * @param i
     * @return
     */
    List<Integer> getAdjacency(int i);
}
