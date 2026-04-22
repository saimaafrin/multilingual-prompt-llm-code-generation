package org.apache.commons.lang3;

public class StringUtils {
    /**
     * Encuentra el último índice dentro de una cadena, manejando <code>null</code>. 
     * Este método utiliza {@link String#lastIndexOf(String)}.
     *
     * @param str la cadena a verificar, puede ser null
     * @param searchStr la cadena a encontrar, puede ser null
     * @return el último índice de la cadena de búsqueda, -1 si no se encuentra o si str es null
     */
    public static int lastIndexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.lastIndexOf(searchStr);
    }
}