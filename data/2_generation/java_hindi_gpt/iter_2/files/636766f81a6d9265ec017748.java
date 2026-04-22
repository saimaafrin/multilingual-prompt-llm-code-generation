import java.util.Base64;

public class Base64Decoder {
    /** 
     * एक स्ट्रिंग को Base64 नियम के अनुसार एक स्ट्रिंग में डिकोड करना। 
     */
    public static String base64Decode(final String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String encodedString = "SGVsbG8gV29ybGQ="; // Example Base64 encoded string
        String decodedString = base64Decode(encodedString);
        System.out.println(decodedString); // Output: Hello World
    }
}