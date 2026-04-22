import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    /**
     * Returns a new array of Strings without null elements. Internal method used to normalize exclude lists (arrays and collections). 
     * Note that {@link Arrays#sort(Object[])} will throw an {@link NullPointerException} if an array element is <code>null</code>.
     * @param array The array to check
     * @return The given array or a new array without null.
     */
    public static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }

        List<String> nonNullList = new ArrayList<>();
        for (Object element : array) {
            if (element != null) {
                nonNullList.add(element.toString());
            }
        }

        return nonNullList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Object[] testArray = {"Hello", null, "World", null, "Java"};
        String[] result = toNoNullStringArray(testArray);
        for (String str : result) {
            System.out.println(str);
        }
    }
}