import java.util.Arrays;

public class Message {
    private byte[] body;

    /**
     * True is the body is a byte array
     * @return True is the body is a byte array
     */
    public boolean hasBytes() {
        return body != null && body.length > 0;
    }
}