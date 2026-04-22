package org.apache.commons.lang3;

/**
 * Utility class for Object operations.
 */
public class ObjectUtils {

    /**
     * <p>Obtiene el <code>toString</code> de un <code>Object</code> devolviendo una cadena vacía ("") 
     * si el argumento es <code>null</code>.</p>
     *
     * <pre>
     * ObjectUtils.toString(null)         = ""
     * ObjectUtils.toString("")           = ""
     * ObjectUtils.toString("bat")        = "bat"
     * ObjectUtils.toString(Boolean.TRUE) = "true"
     * </pre>
     *
     * @see StringUtils#defaultString(String)
     * @see String#valueOf(Object)
     * @param obj  el objeto a procesar mediante <code>toString</code>, puede ser null
     * @return el resultado de aplicar la función "toString" al objeto pasado, o una cadena vacía si el argumento es <code>null</code>
     * @since 2.0
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}