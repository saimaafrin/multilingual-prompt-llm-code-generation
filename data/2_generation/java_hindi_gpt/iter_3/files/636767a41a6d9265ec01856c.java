import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {

    /** 
     * निर्दिष्ट {@code index} से शुरू होने वाले utf8 स्ट्रिंग का आकार निर्दिष्ट {@code length} के साथ गणना करता है।
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        if (index < 0 || index >= str.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Length is invalid");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        String testString = "Hello, 世界"; // Example string
        int size = computeUTF8Size(testString, 7, 2); // Calculate size of "世界"
        System.out.println("UTF-8 size: " + size); // Output the size
    }
}