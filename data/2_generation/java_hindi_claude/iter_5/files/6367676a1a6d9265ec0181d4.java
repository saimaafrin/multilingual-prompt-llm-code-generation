import java.util.Arrays;

public class StringUtils {
    
    public static String[] append(String[] array, String str) {
        if (array == null) {
            return new String[] {str};
        }
        
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }
}