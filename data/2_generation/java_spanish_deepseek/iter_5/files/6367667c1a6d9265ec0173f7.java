import java.util.Arrays;

public class BodyChecker {
    private Object body;

    public BodyChecker(Object body) {
        this.body = body;
    }

    /**
     * Verdadero si el cuerpo es un arreglo de bytes
     * @return Verdadero si el cuerpo es un arreglo de bytes
     */
    public boolean hasBytes() {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        BodyChecker checker1 = new BodyChecker(new byte[]{1, 2, 3});
        System.out.println(checker1.hasBytes()); // true

        BodyChecker checker2 = new BodyChecker("Not a byte array");
        System.out.println(checker2.hasBytes()); // false
    }
}