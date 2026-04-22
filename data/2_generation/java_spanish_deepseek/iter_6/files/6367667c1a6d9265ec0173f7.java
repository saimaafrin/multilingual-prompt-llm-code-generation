import java.util.Arrays;

public class BodyChecker {

    /**
     * Verdadero si el cuerpo es un arreglo de bytes
     * @return Verdadero si el cuerpo es un arreglo de bytes
     */
    public boolean hasBytes(Object body) {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        BodyChecker checker = new BodyChecker();
        byte[] byteArray = new byte[10];
        Object nonByteArray = new Object();

        System.out.println(checker.hasBytes(byteArray)); // true
        System.out.println(checker.hasBytes(nonByteArray)); // false
    }
}