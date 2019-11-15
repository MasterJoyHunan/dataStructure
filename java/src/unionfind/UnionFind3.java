package unionfind;

/**
 * 基于深度的优化
 */
public class UnionFind3 implements UnionFind {

    private int[] parent;
    private int[] parentRank;

    public UnionFind3(int size) {
        parent = new int[size];
        parentRank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            parentRank[i] = 1;
        }
    }


    /**
     * 合并两个集合
     *
     * @param a
     * @param b
     */
    @Override
    public void union(int a, int b) {
        int aParentIndex = find(a);
        int bParentIndex = find(b);
        if (aParentIndex == bParentIndex) {
            return;
        }
        if (parentRank[aParentIndex] < parentRank[bParentIndex]) {
            parent[aParentIndex] = bParentIndex;
        } else if (parentRank[aParentIndex] > parentRank[bParentIndex]) {
            parent[bParentIndex] = aParentIndex;
        } else {
            parent[bParentIndex] = aParentIndex;
            parentRank[aParentIndex] += 1;
        }
    }

    /**
     * 判断两个元素是否属于同一集合
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public boolean find(int a, int b) {
        return find(a) == find(b);
    }

    @Override
    public int getSize() {
        return parent.length;
    }


    private int find(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        if (parent[index] == index) {
            return index;
        }
        return find(parent[index]);
    }
}
