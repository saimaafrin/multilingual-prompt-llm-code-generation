import java.lang.reflect.Array;

public class ArrayUtils {
    
    public static Object[] clone(Object[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }
}