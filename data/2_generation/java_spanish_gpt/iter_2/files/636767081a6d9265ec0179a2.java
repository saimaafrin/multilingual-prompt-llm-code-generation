public class Utility {

    /** 
     * <p>Método de utilidad para {@link #createNumber(String)}.</p> <p>Devuelve <code>true</code> si "s" es <code>null</code>.</p>
     * @param s la cadena a verificar
     * @return si son todos ceros o <code>null</code>
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
        // Test cases
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // true
        System.out.println(isAllZeros("123")); // false
    }
}