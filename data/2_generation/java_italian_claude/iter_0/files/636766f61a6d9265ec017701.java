package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Trova l'ultimo indice all'interno di una Stringa, gestendo <code>null</code>.
     * Questo metodo utilizza {@link String#lastIndexOf(String)}.
     *
     * @param str la Stringa da controllare, può essere null
     * @param searchStr la Stringa da trovare, può essere null
     * @return l'ultimo indice di searchStr in str, -1 se non trovato o se str è null
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
}