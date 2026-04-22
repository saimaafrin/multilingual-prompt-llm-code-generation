import java.lang.reflect.Array;

public class BodyChecker {

    /**
     * True if the body is a byte array
     * @return True if the body is a byte array
     */
    public boolean hasBytes(Object body) {
        if (body == null) {
            return false;
        }
        return body.getClass().isArray() && body.getClass().getComponentType() == byte.class;
    }
}