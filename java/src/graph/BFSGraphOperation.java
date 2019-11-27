package graph;

import queue.Queue;
import queue.QueueLoopArray;

import java.util.*;

/**
 * 操作图的算法
 */
public class BFSGraphOperation {

    // 图
    private Graph graph;

    // 存放每个遍历过了的顶点
    private boolean[] hasVisit;

    // 对某个点进行操作
    int source;

    // 存放路径
    int[] from;

    // source到某个顶点的需要经过的边
    int[] order;


    /**
     * 深度优先
     *
     * @param graph
     * @param source
     */
    public BFSGraphOperation(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        int total = graph.getVertexCount();
        this.from = new int[total];
        this.order = new int[total];
        hasVisit = new boolean[total];

        for (int i = 0; i < total; i++) {
            from[i] = -1;
            order[i] = -1;
        }
        // 寻路算法 广度优先
        BFS(source);
    }

    /**
     * 广度优先算法
     *
     * @param i
     */
    private void BFS(int i) {
        hasVisit[i] = true;
        order[i] = 0;
        Queue<Integer> queue = new QueueLoopArray<>();
        queue.enqueue(i);
        int current;
        while (!queue.isEmpty()) {
            current = queue.dequeue();
            List<Integer> next = graph.getAdjacency(current);
            for (Integer item : next) {
                if (!hasVisit[item]) {
                    queue.enqueue(item);
                    order[item] = order[current] + 1;
                    hasVisit[item] = true;
                    from[item] = current;
                }
            }
        }
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


    /**
     * 如果有路的话，具体是什么路径
     *
     * @param w
     * @param path
     */
    public void path(int w, List<Integer> path) {
        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        path.clear();
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
    }


    /**
     * 查看路径
     *
     * @param w
     */
    public void showPath(int w) {
        List<Integer> paths = new ArrayList<>();
        path(w, paths);
        for (Integer i : paths) {
            System.out.print(i + " -> ");
        }
    }

    public static void main(String[] args) {
        // 初始化
        AdjacencyList graph = new AdjacencyList(9);
        Random R = new Random();
        for (int i = 0; i < 20; i++) {
            graph.insertEdge(R.nextInt(9), R.nextInt(9));
        }
        Iterator it = graph.iterator();
        for (int i = 0; it.hasNext(); ) {
            System.out.println(i + " => " + it.next());
            i++;
        }

        BFSGraphOperation go2 = new BFSGraphOperation(graph, 5);
        int path = R.nextInt(8);
        System.out.println("find path : " + path);
        System.out.println("has path? " + go2.hasPath(path));
        go2.showPath(path);
    }
}
