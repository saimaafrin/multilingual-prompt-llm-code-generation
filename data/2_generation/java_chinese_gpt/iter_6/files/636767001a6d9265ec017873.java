public class StringUtils {
    
    /**
     * <p>根据 {@link StringBuilder#reverse()} 方法反转字符串。</p>
     * <p>一个 <code>null</code> 字符串返回 <code>null</code>。</p>
     * <pre> 
     * StringUtils.reverse(null)  = null 
     * StringUtils.reverse("")    = "" 
     * StringUtils.reverse("bat") = "tab" 
     * </pre>
     * @param str  要反转的字符串，可以为空
     * @return 反转后的字符串，如果输入字符串为空，则返回 <code>null</code>
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(null));  // 输出: null
        System.out.println(reverse(""));    // 输出: ""
        System.out.println(reverse("bat"));  // 输出: "tab"
    }
}