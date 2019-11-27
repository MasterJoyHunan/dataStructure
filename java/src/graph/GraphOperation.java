package graph;

import java.util.*;

/**
 * 操作图的算法
 */
public class GraphOperation {

    // 图
    private Graph graph;

    // 图的连通分量
    private int connectCount = 0;

    // 每个顶点的所处的连通分量
    private int[] belongConnect;

    // 存放每个遍历过了的顶点
    private boolean[] hasVisit;


    public GraphOperation(Graph graph) {
        this.graph = graph;
        int total = graph.getVertexCount();
        belongConnect = new int[total];
        hasVisit = new boolean[total];
        for (int i = 0; i < total; i++) {
            if (!hasVisit[i]) {
                DFS(i);
                connectCount++;
            }
        }
    }



    /**
     * 深度优先算法
     *
     * @param i
     */
    private void DFS(int i) {
        hasVisit[i] = true;
        belongConnect[i] = connectCount;
        for (Integer item : graph.getAdjacency(i)) {
            if (!hasVisit[item]) {
                DFS(item);
            }
        }
    }


    /**
     * 判断两个顶点是否连接（直接、间接）
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isConnect(int i, int j) {
        return belongConnect[i] == belongConnect[j];
    }

    /**
     * 该图含有多少个连通分量
     *
     * @return
     */
    public int getConnectCount() {
        return connectCount;
    }

    /**
     * source 到 i 点是否有路
     *
     * @param i
     * @return
     */
    public boolean hasPath(int i) {
        return hasVisit[i];
    }



    public static void main(String[] args) {
        // 初始化
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
