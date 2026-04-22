package org.apache.commons.lang3;

/**
 * Utility class for Boolean operations.
 */
public class BooleanUtils {

    /**
     * <p>Checks if a <code>Boolean</code> value is <i>not</i> <code>true</code>,
     * handling <code>null</code> by returning <code>true</code>.</p>
     *
     * <pre>
     * BooleanUtils.isNotTrue(Boolean.TRUE)  = false
     * BooleanUtils.isNotTrue(Boolean.FALSE) = true
     * BooleanUtils.isNotTrue(null)          = true
     * </pre>
     *
     * @param bool  the boolean to check, null returns <code>true</code>
     * @return <code>true</code> if the input is null or false
     * @since 2.3
     */
    public static boolean isNotTrue(Boolean bool) {
        return !Boolean.TRUE.equals(bool);
    }
}