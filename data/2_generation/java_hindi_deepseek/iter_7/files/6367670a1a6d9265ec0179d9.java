public class StringUtils {

    /**
     * एक स्ट्रिंग की लंबाई प्राप्त करता है या यदि स्ट्रिंग <code>null</code> है तो <code>0</code> लौटाता है।
     * @param str एक स्ट्रिंग या <code>null</code>
     * @return स्ट्रिंग की लंबाई या यदि स्ट्रिंग <code>null</code> है तो <code>0</code>।
     * @since 2.4
     */
    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(length(null));      // Output: 0
        System.out.println(length(""));       // Output: 0
        System.out.println(length("Hello"));  // Output: 5
    }
}