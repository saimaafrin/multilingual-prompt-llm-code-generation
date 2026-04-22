public class StringUtils {

    /**
     * <p>एक स्ट्रिंग को {@link StringBuilder#reverse()} के अनुसार उलटता है।</p> 
     * <p>एक <code>null</code> स्ट्रिंग <code>null</code> लौटाता है।</p> 
     * <pre> 
     * StringUtils.reverse(null)  = null 
     * StringUtils.reverse("")    = "" 
     * StringUtils.reverse("bat") = "tab" 
     * </pre>
     * @param str  वह स्ट्रिंग जिसे उलटना है, यह null हो सकता है
     * @return उलटी हुई स्ट्रिंग, यदि इनपुट स्ट्रिंग null है तो <code>null</code>
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(null));  // null
        System.out.println(reverse(""));    // ""
        System.out.println(reverse("bat")); // "tab"
    }
}