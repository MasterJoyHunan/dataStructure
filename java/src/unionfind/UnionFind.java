package unionfind;

public interface UnionFind {

    /**
     * 合并两个集合
     *
     * @param a
     * @param b
     */
    void union(int a, int b);

    /**
     * 判断两个元素是否属于同一集合
     *
     * @param a
     * @param b
     * @return
     */
    boolean find(int a, int b);


    int getSize();
}
