import java.util.Base64;

public class Base64Decoder {
    
    /**
     * Decoding a string to a string follow the Base64 regular.
     * @param encodedString The Base64 encoded string to decode
     * @return The decoded string
     */
    public String decodeString(String encodedString) {
        if (encodedString == null || encodedString.isEmpty()) {
            return "";
        }
        
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            // Return empty string if input is not valid Base64
            return "";
        }
    }
}