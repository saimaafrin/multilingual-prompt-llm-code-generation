import java.util.Objects;

public class StringArrayTrimmer {
    
    public static String[] trimElements(String[] array) {
        if (array == null) {
            return null;
        }
        
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.nonNull(array[i]) ? array[i].trim() : null;
        }
        return result;
    }
}