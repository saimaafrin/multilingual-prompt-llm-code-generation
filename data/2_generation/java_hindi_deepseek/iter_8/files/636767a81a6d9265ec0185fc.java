import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream inputStream;

    public TagReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * एक फ़ील्ड टैग पढ़ने का प्रयास करें, यदि हम EOF पर पहुँच गए हैं तो शून्य लौटाएँ। प्रोटोकॉल संदेश पार्सर टैग पढ़ने के लिए इसका उपयोग करते हैं, क्योंकि एक प्रोटोकॉल संदेश वैध रूप से किसी भी टैग के स्थान पर समाप्त हो सकता है, और शून्य एक मान्य टैग संख्या नहीं है।
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        if (tag == -1) {
            return 0; // EOF पर पहुँच गए हैं, शून्य लौटाएँ
        }
        return tag;
    }
}