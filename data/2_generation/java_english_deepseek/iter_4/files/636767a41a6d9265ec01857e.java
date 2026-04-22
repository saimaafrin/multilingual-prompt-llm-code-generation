/**
 * Compares the two specified {@code long} values. The sign of the value returned is the same as that of
 * {@code ((Long) a).compareTo(b)}. <p> <b>Note for Java 7 and later:</b> this method should be treated as deprecated;
 * use the equivalent {@link Long#compare} method instead.
 * 
 * @param a the first {@code long} to compare
 * @param b the second {@code long} to compare
 * @return a negative value if {@code a} is less than {@code b}; a positive value if {@code a} is greater than
 *         {@code b}; or zero if they are equal
 */
private static int compareSigned(long a, long b) {
    return Long.compare(a, b);
}