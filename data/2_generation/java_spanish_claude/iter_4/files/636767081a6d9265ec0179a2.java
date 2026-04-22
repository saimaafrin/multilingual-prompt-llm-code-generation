public class NumberUtils {
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
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}