import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        double epsilon = 1e-10; // 用于处理浮点数精度问题
        double diff = o1 - o2;
        if (Math.abs(diff) < epsilon) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}