import java.util.Comparator;

public class FloatComparator implements Comparator<Double> {
    
    /** 
     * 比较两个浮点值。如果它们相等则返回0，如果 {@literal o1 < o2} 则返回-1，否则返回1
     * @param o1 第一个值
     * @param o2 第二个值
     * @return 如果它们相等则返回0，如果 {@literal o1 < o2} 则返回-1，否则返回1
     */
    @Override
    public int compare(Double o1, Double o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    }
}