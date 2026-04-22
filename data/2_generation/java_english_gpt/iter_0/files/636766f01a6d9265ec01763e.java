import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetTranslator {

    /** 
     * Translate a MIME standard character set name into the Java equivalent.
     * @param charset The MIME standard name.
     * @return The Java equivalent for this name.
     */
    private static String javaCharset(String charset) {
        Map<String, String> mimeToJavaCharsetMap = new HashMap<>();
        mimeToJavaCharsetMap.put("UTF-8", "UTF-8");
        mimeToJavaCharsetMap.put("ISO-8859-1", "ISO-8859-1");
        mimeToJavaCharsetMap.put("US-ASCII", "US-ASCII");
        mimeToJavaCharsetMap.put("UTF-16", "UTF-16");
        mimeToJavaCharsetMap.put("UTF-16BE", "UTF-16BE");
        mimeToJavaCharsetMap.put("UTF-16LE", "UTF-16LE");
        mimeToJavaCharsetMap.put("windows-1252", "windows-1252");
        mimeToJavaCharsetMap.put("windows-1251", "windows-1251");
        mimeToJavaCharsetMap.put("windows-1250", "windows-1250");
        mimeToJavaCharsetMap.put("windows-1253", "windows-1253");
        mimeToJavaCharsetMap.put("windows-1254", "windows-1254");
        mimeToJavaCharsetMap.put("windows-1255", "windows-1255");
        mimeToJavaCharsetMap.put("windows-1256", "windows-1256");
        mimeToJavaCharsetMap.put("windows-1257", "windows-1257");
        mimeToJavaCharsetMap.put("windows-1258", "windows-1258");

        return mimeToJavaCharsetMap.getOrDefault(charset, Charset.forName(charset).name());
    }
}