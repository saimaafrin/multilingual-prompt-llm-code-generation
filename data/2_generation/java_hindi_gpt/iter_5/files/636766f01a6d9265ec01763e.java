import java.nio.charset.Charset;

public class CharsetConverter {
    /** 
     * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
     * @param charset MIME मानक नाम।
     * @return इस नाम के लिए जावा समकक्ष।
     */
    private static String javaCharset(String charset) {
        Charset javaCharset = Charset.forName(charset);
        return javaCharset.name();
    }

    public static void main(String[] args) {
        // Example usage
        String mimeCharset = "UTF-8";
        String javaEquivalent = javaCharset(mimeCharset);
        System.out.println("Java equivalent of " + mimeCharset + " is " + javaEquivalent);
    }
}