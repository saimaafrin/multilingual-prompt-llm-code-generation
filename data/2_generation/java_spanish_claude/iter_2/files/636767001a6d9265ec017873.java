import java.lang.StringBuilder;

public class StringUtils {

    /**
     * <p>Invierte una cadena de acuerdo con {@link StringBuilder#reverse()}.</p>
     * <p>Una cadena <code>null</code> devuelve <code>null</code>.</p>
     * <pre>
     * StringUtils.reverse(null)  = null
     * StringUtils.reverse("")    = ""
     * StringUtils.reverse("bat") = "tab"
     * </pre>
     * @param str  la cadena a invertir, puede ser null
     * @return la cadena invertida, <code>null</code> si la entrada es una cadena null
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}