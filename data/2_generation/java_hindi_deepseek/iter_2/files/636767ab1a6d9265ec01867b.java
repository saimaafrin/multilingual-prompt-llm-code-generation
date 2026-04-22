import java.nio.charset.StandardCharsets;
import org.apache.avro.io.LinkedBuffer;
import org.apache.avro.io.WriteSession;

public class UTF8Writer {

    /**
     * स्ट्रिंग से UTF8-कोडित बाइट्स को {@link LinkedBuffer} में लिखता है।
     *
     * @param str     लिखने के लिए स्ट्रिंग
     * @param session लिखने का सत्र
     * @param lb      लिंक्ड बफर जिसमें डेटा लिखा जाएगा
     * @return लिंक्ड बफर जिसमें UTF8-कोडित बाइट्स लिखे गए हैं
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Input parameters cannot be null.");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        LinkedBuffer currentBuffer = lb;

        for (byte b : utf8Bytes) {
            if (currentBuffer.isFull()) {
                currentBuffer = session.nextBuffer();
            }
            currentBuffer.append(b);
        }

        return currentBuffer;
    }
}