/**
 * <p>जांचें कि एक String एक निर्दिष्ट उपसर्ग के साथ समाप्त होता है (वैकल्पिक रूप से केस संवेदनशीलता को अनदेखा करते हुए)।</p>
 * @see String#endsWith(String)
 * @param str  वह String जिसे जांचना है, यह null हो सकता है
 * @param suffix वह उपसर्ग जिसे खोजना है, यह null हो सकता है
 * @param ignoreCase यह दर्शाता है कि तुलना में केस को अनदेखा करना चाहिए या नहीं (केस संवेदनशीलता को अनदेखा करना)।
 * @return <code>true</code> यदि String उपसर्ग के साथ शुरू होता है या दोनों <code>null</code> हैं
 */
private static boolean endsWith(final String str, final String suffix, final boolean ignoreCase) {
    if (str == null && suffix == null) {
        return true;
    }
    if (str == null || suffix == null) {
        return false;
    }
    if (suffix.length() > str.length()) {
        return false;
    }
    String strEnd = str.substring(str.length() - suffix.length());
    if (ignoreCase) {
        return strEnd.equalsIgnoreCase(suffix);
    } else {
        return strEnd.equals(suffix);
    }
}