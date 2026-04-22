public class NumberUtils {
    /**
     * <p>Metodo di utilità per {@link #createNumber(String)}.</p>
     * <p>Restituisce <code>true</code> se s è <code>null</code>.</p>
     * @param s la String da controllare
     * @return se è composta solo da zeri o <code>null</code>
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