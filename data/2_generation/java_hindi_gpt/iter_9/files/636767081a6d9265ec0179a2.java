public class NumberUtils {

    /** 
     * <p>{@link #createNumber(String)} के लिए उपयोगिता विधि।</p> 
     * <p>यदि s <code>null</code> है तो <code>true</code> लौटाता है।</p>
     * @param s वह String जिसे जांचना है
     * @return यदि यह सभी शून्य हैं या <code>null</code> है
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        for (char c : s.toCharArray()) {
            if (c != '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // true
    }
}