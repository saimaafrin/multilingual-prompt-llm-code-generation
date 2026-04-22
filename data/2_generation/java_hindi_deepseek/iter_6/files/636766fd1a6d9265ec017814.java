public static boolean arrayequals(byte[] a, byte[] b, int count) {
    // Check if either array is null or if count is negative
    if (a == null || b == null || count < 0) {
        return false;
    }

    // If count is greater than the length of either array, return false
    if (count > a.length || count > b.length) {
        return false;
    }

    // Compare the first 'count' bytes of both arrays
    for (int i = 0; i < count; i++) {
        if (a[i] != b[i]) {
            return false;
        }
    }

    // If all bytes are equal, return true
    return true;
}