import java.util.Base64;

public class Base64Decoder {

    /**
     * Decodifica una stringa seguendo la regola Base64.
     * 
     * @param s La stringa codificata in Base64 da decodificare.
     * @return La stringa decodificata.
     */
    public static String base64Decode(final String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String encodedString = "SGVsbG8gV29ybGQh"; // Esempio di stringa codificata in Base64
        String decodedString = base64Decode(encodedString);
        System.out.println(decodedString); // Output: "Hello World!"
    }
}