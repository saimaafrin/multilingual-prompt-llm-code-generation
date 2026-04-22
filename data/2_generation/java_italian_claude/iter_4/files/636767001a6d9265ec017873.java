package org.apache.commons.lang3;

public class StringUtils {
    /**
     * <p>Inverte una Stringa come per {@link StringBuilder#reverse()}.</p>
     * <p>Una Stringa <code>null</code> restituisce <code>null</code>.</p>
     * <pre>
     * StringUtils.reverse(null)  = null
     * StringUtils.reverse("")    = ""
     * StringUtils.reverse("bat") = "tab"
     * </pre>
     * 
     * @param str la Stringa da invertire, può essere null
     * @return la Stringa invertita, <code>null</code> se l'input è una Stringa null
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}