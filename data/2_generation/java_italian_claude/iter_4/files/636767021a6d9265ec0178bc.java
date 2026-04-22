package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Trova il primo indice all'interno di una Stringa, gestendo <code>null</code>.
     * Questo metodo utilizza {@link String#indexOf(String)}.
     *
     * @param str la Stringa da controllare, può essere null
     * @param searchStr la Stringa da trovare, può essere null
     * @return l'indice della prima occorrenza, -1 se non trovata o se str è null
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }
}