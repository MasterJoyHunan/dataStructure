package tree;

/**
 * 求 l - r 之间的和
 *
 * @author joy
 * @time 2019/11/13 20:11
 */
public class SegmentArray {

//    private int[] data;
    private int[] sum;

    public SegmentArray(int[] data) {
        this.data = data.clone();
        sum = new int[data.length + 1];
        for (int i = 1; i < data.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int getRange(int l, int r) {
        return sum[r + 1] - sum[l];
    }


}
