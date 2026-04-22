public class Utility {

    /** 
     * <p>Utility method for  {@link #createNumber(String)}.</p> <p>Returns <code>true</code> if s is <code>null</code>.</p>
     * @param s the String to check
     * @return if it is all zeros or <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        return s.chars().allMatch(c -> c == '0');
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // false
    }
}