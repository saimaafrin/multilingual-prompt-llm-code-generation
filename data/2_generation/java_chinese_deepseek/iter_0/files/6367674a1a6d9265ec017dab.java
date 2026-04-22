import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    /**
     * 比较两个浮点值。如果它们相等则返回0，如果 {@literal o1 < o2} 则返回-1，否则返回1
     * @param o1 第一个值
     * @param o2 第二个值
     * @return 如果它们相等则返回0，如果 {@literal o1 < o2} 则返回-1，否则返回1
     */
    @Override
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else if (Math.abs(o1 - o2) < 1e-9) {
            return 0;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 1;
        }
    }
}