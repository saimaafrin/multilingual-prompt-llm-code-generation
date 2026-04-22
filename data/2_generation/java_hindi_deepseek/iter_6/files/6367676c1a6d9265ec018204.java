import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // If both arrays are null, return null
        if (array1 == null && array2 == null) {
            return null;
        }

        // If one of the arrays is null, return the other array
        if (array1 == null) {
            return array2;
        }
        if (array2 == null) {
            return array1;
        }

        // Create a list to hold the concatenated elements
        List<String> resultList = new ArrayList<>();

        // Add all elements from the first array
        for (String element : array1) {
            resultList.add(element);
        }

        // Add all elements from the second array
        for (String element : array2) {
            resultList.add(element);
        }

        // Convert the list to an array and return
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"Java", "Programming"};

        String[] result = concatenateStringArrays(array1, array2);

        for (String element : result) {
            System.out.println(element);
        }
    }
}