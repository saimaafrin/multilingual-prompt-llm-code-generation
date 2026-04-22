package org.apache.commons.lang3;

/**
 * Utility class for Boolean operations.
 */
public class BooleanUtils {

    /**
     * <p>Controlla se un valore <code>Boolean</code> è <i>non</i> <code>true</code>, 
     * gestendo <code>null</code> restituendo <code>true</code>.</p>
     *
     * <pre>
     * BooleanUtils.isNotTrue(Boolean.TRUE)  = false
     * BooleanUtils.isNotTrue(Boolean.FALSE) = true
     * BooleanUtils.isNotTrue(null)          = true
     * </pre>
     *
     * @param bool  il booleano da controllare, null restituisce <code>true</code>
     * @return <code>true</code> se l'input è null o false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return !Boolean.TRUE.equals(bool);
    }
}