import java.util.Base64;

public class Base64Decoder {
    /**
     * Decodificación de una cadena a una cadena siguiendo la norma Base64.
     * @param s La cadena codificada en Base64.
     * @return La cadena decodificada.
     */
    public static String base64Decode(final String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }
}