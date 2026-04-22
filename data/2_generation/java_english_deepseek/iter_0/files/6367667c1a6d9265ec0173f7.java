import java.util.Objects;

public class Example {
    private Object body;

    public Example(Object body) {
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
        Example example1 = new Example(new byte[]{1, 2, 3});
        System.out.println(example1.hasBytes()); // Output: true

        Example example2 = new Example("Not a byte array");
        System.out.println(example2.hasBytes()); // Output: false
    }
}