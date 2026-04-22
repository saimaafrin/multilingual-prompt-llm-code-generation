/**
 * <p>{@link #createNumber(String)} के लिए उपयोगिता विधि।</p> <p>यदि s <code>null</code> है तो <code>true</code> लौटाता है।</p>
 * @param s वह String जिसे जांचना है
 * @return यदि यह सभी शून्य हैं या <code>null</code> है
 */
private static boolean isAllZeros(String s) {
    if (s == null) {
        return true;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '0') {
            return false;
        }
    }
    return true;
}