package tree;

/**
 * 求 l - r 之间的和
 *
 * @author joy
 * @time 2019/11/13 20:11
 */
public class SegmentArray {

    private int[] data;
    private int[] sum;

    public SegmentArray(int[] data) {
        this.data = data.clone();
        sum = new int[data.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public void update(int index, int value) {
        data[index] = value;
        for (int i = index; i < sum.length; i++) {
            sum[i] = sum[i - 1] +  data[i - 1];
        }
    }

    public int getRange(int l, int r) {
        return sum[r + 1] - sum[l];
    }

    public static void main(String[] args) {

        SegmentArray t = new SegmentArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(t.getRange(0, 2));
        System.out.println(t.getRange(2, 5));
        System.out.println(t.getRange(0, 5));
    }

}
