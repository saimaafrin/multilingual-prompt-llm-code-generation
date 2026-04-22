public static boolean arrayequals(byte[] a, byte[] b, int count) {
    if (a == null || b == null) {
        return a == b;
    }
    if (a.length < count || b.length < count) {
        return false;
    }
    for (int i = 0; i < count; i++) {
        if (a[i] != b[i]) {
            return false;
        }
    }
    return true;
}