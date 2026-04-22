import java.util.Arrays;

public class BodyValidator {
    private byte[] body;
    
    public BodyValidator(byte[] body) {
        this.body = body;
    }

    /**
     * True is the body is a byte array
     * @return True is the body is a byte array
     */
    public boolean isByteArray() {
        if (body == null) {
            return false;
        }
        return body.getClass().isArray() && body.getClass().getComponentType() == byte.class;
    }
}