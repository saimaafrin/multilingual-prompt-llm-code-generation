public class NumberUtils {

    /** 
     * <p>Utility method for  {@link #createNumber(String)}.</p> 
     * <p>Returns <code>true</code> if s is <code>null</code>.</p>
     * @param s the String to check
     * @return if it is all zeros or <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        return s.trim().equals("0") || s.trim().equals("0.0") || s.trim().equals("0.00");
    }

    public static void main(String[] args) {
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0")); // true
        System.out.println(isAllZeros("0.0")); // true
        System.out.println(isAllZeros("0.00")); // true
        System.out.println(isAllZeros("1")); // false
        System.out.println(isAllZeros("")); // false
    }
}