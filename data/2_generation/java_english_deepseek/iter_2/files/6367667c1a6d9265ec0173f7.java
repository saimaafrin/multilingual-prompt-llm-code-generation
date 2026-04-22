public class ByteChecker {
    /**
     * True if the body is a byte array
     * @return True if the body is a byte array
     */
    public boolean hasBytes(Object body) {
        return body instanceof byte[];
    }
}