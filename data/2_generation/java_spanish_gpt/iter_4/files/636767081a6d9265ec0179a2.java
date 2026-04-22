public class Utility {

    /** 
     * <p>Método de utilidad para {@link #createNumber(String)}.</p> 
     * <p>Devuelve <code>true</code> si "s" es <code>null</code>.</p>
     * @param s la cadena a verificar
     * @return si son todos ceros o <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        return s.chars().allMatch(c -> c == '0');
    }

    public static void main(String[] args) {
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // false
    }
}