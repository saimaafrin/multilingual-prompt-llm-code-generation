import java.util.Base64;

public class Base64Decoder {
    /**
     * एक स्ट्रिंग को Base64 नियम के अनुसार एक स्ट्रिंग में डिकोड करना।
     * @param s Base64 एन्कोडेड स्ट्रिंग
     * @return डिकोडेड स्ट्रिंग
     */
    public static String base64Decode(final String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String encodedString = "SGVsbG8gV29ybGQh"; // Example Base64 encoded string
        String decodedString = base64Decode(encodedString);
        System.out.println(decodedString); // Output: Hello World!
    }
}