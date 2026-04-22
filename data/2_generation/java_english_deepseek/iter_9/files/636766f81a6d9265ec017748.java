import java.util.Base64;

public class Base64Decoder {
    /**
     * Decoding a string to a string follow the Base64 regular.
     * @param s The Base64 encoded string to decode.
     * @return The decoded string.
     */
    public static String base64Decode(final String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }
}