import java.util.Arrays;

public class BodyChecker {

    /**
     * Restituisce true se il corpo è un array di byte
     * @return true se il corpo è un array di byte
     */
    public boolean hasBytes(Object body) {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        BodyChecker checker = new BodyChecker();
        byte[] byteArray = new byte[10];
        String notByteArray = "Not a byte array";

        System.out.println(checker.hasBytes(byteArray)); // Output: true
        System.out.println(checker.hasBytes(notByteArray)); // Output: false
    }
}