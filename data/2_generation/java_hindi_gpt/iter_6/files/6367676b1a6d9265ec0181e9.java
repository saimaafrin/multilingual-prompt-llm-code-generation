public class SubstringMatcher {

    /** 
     * यदि दी गई स्ट्रिंग दी गई उपस्ट्रिंग के साथ दी गई इंडेक्स पर मेल खाती है, तो {@code true} लौटाता है, अन्यथा {@code false}।
     * @param str मूल स्ट्रिंग (या StringBuilder)
     * @param index मूल स्ट्रिंग में मेल शुरू करने के लिए इंडेक्स
     * @param substring दी गई इंडेक्स पर मेल करने के लिए उपस्ट्रिंग
     * @return {@code true} यदि दी गई स्ट्रिंग दी गई उपस्ट्रिंग के साथ दी गई इंडेक्स पर मेल खाती है, अन्यथा {@code false}।
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        if (index < 0 || index + substring.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello, world!";
        String substring = "world";
        int index = 7;

        boolean result = substringMatch(str, index, substring);
        System.out.println("Does the substring match? " + result); // Output: true
    }
}