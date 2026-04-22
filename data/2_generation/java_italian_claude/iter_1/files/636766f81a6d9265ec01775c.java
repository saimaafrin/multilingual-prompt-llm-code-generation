package org.apache.commons.lang3;

/**
 * Utility class for Object operations.
 */
public class ObjectUtils {

    /**
     * <p>Restituisce il <code>toString</code> di un <code>Object</code> restituendo una stringa vuota ("") se l'input è <code>null</code>.</p>
     * <pre>
     * ObjectUtils.toString(null)         = ""
     * ObjectUtils.toString("")           = ""
     * ObjectUtils.toString("bat")        = "bat"
     * ObjectUtils.toString(Boolean.TRUE) = "true"
     * </pre>
     *
     * @see StringUtils#defaultString(String)
     * @see String#valueOf(Object)
     * @param obj l'oggetto da <code>toString</code>, può essere null
     * @return il toString dell'oggetto passato, o una stringa vuota se l'input è <code>null</code>
     * @since 2.0
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}