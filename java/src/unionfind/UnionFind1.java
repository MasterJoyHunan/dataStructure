package unionfind;

public class UnionFind1 implements UnionFind{

    private int[] data;

    public UnionFind1(int[] data) {
        this.data = data.clone();
    }


    /**
     *
     * @param a
     * @param b
     */
    @Override
    public void union(int a, int b) {
        int aBelong = find(a);
        int bBelong = find(b);
        if (aBelong == bBelong) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == aBelong) {
                data[i] = bBelong;
            }
        }

    }

    @Override
    public boolean find(int a, int b) {
        return find(a) == find(b);
    }


    private int find(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        return data[index];
    }
}
