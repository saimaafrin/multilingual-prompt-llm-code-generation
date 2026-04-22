package org.apache.commons.lang3;

public class CharUtils {
    /**
     * <p>Checks whether the character is ASCII 7 bit control.</p>
     * <pre>
     * CharUtils.isAsciiControl('a')  = false
     * CharUtils.isAsciiControl('A')  = false 
     * CharUtils.isAsciiControl('3')  = false
     * CharUtils.isAsciiControl('-')  = false
     * CharUtils.isAsciiControl('\n') = true
     * CharUtils.isAsciiControl('&copy;') = false
     * </pre>
     * @param ch  the character to check
     * @return true if less than 32 or equals 127
     */
    public static boolean isAsciiControl(char ch) {
        return ch < 32 || ch == 127;
    }
}