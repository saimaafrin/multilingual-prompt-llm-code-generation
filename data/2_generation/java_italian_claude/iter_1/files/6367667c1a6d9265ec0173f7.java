import java.util.Arrays;

public class Message {
    private byte[] body;

    /**
     * Restituisce true se il corpo è un array di byte
     * @return true se il corpo è un array di byte
     */
    public boolean hasBytes() {
        return body != null && body.length > 0;
    }

    // Constructor
    public Message(byte[] body) {
        this.body = body;
    }
}