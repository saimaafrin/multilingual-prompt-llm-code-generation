import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTranslator {

    /**
     * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
     * @param charset MIME मानक नाम।
     * @return इस नाम के लिए जावा समकक्ष।
     */
    private static String javaCharset(String charset) {
        switch (charset.toLowerCase()) {
            case "us-ascii":
                return StandardCharsets.US_ASCII.name();
            case "iso-8859-1":
                return StandardCharsets.ISO_8859_1.name();
            case "utf-8":
                return StandardCharsets.UTF_8.name();
            case "utf-16":
                return StandardCharsets.UTF_16.name();
            case "utf-16be":
                return StandardCharsets.UTF_16BE.name();
            case "utf-16le":
                return StandardCharsets.UTF_16LE.name();
            default:
                // यदि कोई मानक मैच नहीं है, तो मूल चारसेट नाम वापस करें
                return Charset.forName(charset).name();
        }
    }

    public static void main(String[] args) {
        // परीक्षण उदाहरण
        System.out.println(javaCharset("utf-8")); // "UTF-8"
        System.out.println(javaCharset("iso-8859-1")); // "ISO-8859-1"
        System.out.println(javaCharset("unknown-charset")); // "unknown-charset" (यदि यह मान्य है)
    }
}