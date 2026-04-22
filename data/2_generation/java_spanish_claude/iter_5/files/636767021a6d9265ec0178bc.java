package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Encuentra el primer índice dentro de una cadena, manejando <code>null</code>. 
     * Este método utiliza {@link String#indexOf(String)}.
     *
     * @param str la cadena a verificar, puede ser null
     * @param searchStr la cadena a encontrar, puede ser null
     * @return el primer índice de searchStr en str, -1 si no se encuentra o si str o searchStr son null
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }
}