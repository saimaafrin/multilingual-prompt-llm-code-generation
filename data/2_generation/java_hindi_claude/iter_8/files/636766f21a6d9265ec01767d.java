package com.utils;

public class StringUtils {
    /**
     * Object to String, when null object then null else return toString()
     * @param obj Object to convert to string
     * @return String representation of object or null if object is null
     */
    public static String toString(Object obj) {
        return obj == null ? null : obj.toString();
    }
}