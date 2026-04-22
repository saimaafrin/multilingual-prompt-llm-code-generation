import java.util.Base64;

public class Base64Decoder {
    /**
     * Decodifica una stringa seguendo la regola Base64.
     */
    public static String base64Decode(final String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(s);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            return "";
        }
    }
}