package org.apache.commons.lang3;

/**
 * Utility class for Boolean operations.
 */
public class BooleanUtils {

    /**
     * <p>Converte un Boolean in un boolean gestendo <code>null</code> restituendo <code>false</code>.</p>
     * 
     * <pre>
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false 
     * BooleanUtils.toBoolean(null)          = false
     * </pre>
     *
     * @param bool  il boolean da convertire
     * @return <code>true</code> o <code>false</code>, <code>null</code> restituisce <code>false</code>
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

}