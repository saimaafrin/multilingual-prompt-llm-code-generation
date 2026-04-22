import java.util.Objects;

public class BodyChecker {
    private Object body;

    public BodyChecker(Object body) {
        this.body = body;
    }

    /**
     * True if the body is a byte array
     * @return True if the body is a byte array
     */
    public boolean hasBytes() {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        BodyChecker checker1 = new BodyChecker(new byte[]{1, 2, 3});
        System.out.println(checker1.hasBytes()); // Output: true

        BodyChecker checker2 = new BodyChecker("Not a byte array");
        System.out.println(checker2.hasBytes()); // Output: false
    }
}