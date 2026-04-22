public class ByteArrayChecker {

    private Object body;

    public ByteArrayChecker(Object body) {
        this.body = body;
    }

    /** 
     * True is the body is a byte array
     * @return True is the body is a byte array
     */
    public boolean hasBytes() {
        return body instanceof byte[];
    }

    public static void main(String[] args) {
        ByteArrayChecker checker1 = new ByteArrayChecker(new byte[]{1, 2, 3});
        System.out.println(checker1.hasBytes()); // true

        ByteArrayChecker checker2 = new ByteArrayChecker("Not a byte array");
        System.out.println(checker2.hasBytes()); // false
    }
}