import java.nio.charset.Charset;

public class CharsetConverter {
    /** 
     * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
     * @param charset MIME मानक नाम।
     * @return इस नाम के लिए जावा समकक्ष।
     */
    private static String javaCharset(String charset) {
        Charset cs = Charset.forName(charset);
        return cs.name();
    }

    public static void main(String[] args) {
        // उदाहरण के लिए उपयोग
        String mimeCharset = "UTF-8";
        String javaCharset = javaCharset(mimeCharset);
        System.out.println("Java Charset: " + javaCharset);
    }
}