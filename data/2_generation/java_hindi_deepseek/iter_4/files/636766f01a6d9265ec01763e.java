import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * एक MIME मानक वर्ण सेट नाम को जावा समकक्ष में अनुवादित करें।
 * @param charset MIME मानक नाम।
 * @return इस नाम के लिए जावा समकक्ष।
 */
private static String javaCharset(String charset) {
    try {
        // MIME charset को Java charset में बदलें
        return Charset.forName(charset).name();
    } catch (UnsupportedCharsetException e) {
        // यदि charset समर्थित नहीं है, तो डिफ़ॉल्ट charset लौटाएं
        return Charset.defaultCharset().name();
    }
}