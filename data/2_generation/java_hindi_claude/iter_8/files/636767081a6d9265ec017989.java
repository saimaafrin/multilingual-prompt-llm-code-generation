package org.apache.commons.lang3;

public class BooleanUtils {
    
    public static boolean[] toPrimitive(Boolean[] array) {
        if (array == null) {
            return null;
        }

        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].booleanValue();
        }
        return result;
    }
}