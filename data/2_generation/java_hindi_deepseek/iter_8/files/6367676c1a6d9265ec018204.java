import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        // Handle null cases
        if (array1 == null && array2 == null) {
            return null;
        } else if (array1 == null) {
            return array2.clone();
        } else if (array2 == null) {
            return array1.clone();
        }

        // Create a list to hold the concatenated elements
        List<String> resultList = new ArrayList<>();

        // Add elements from array1
        for (String element : array1) {
            resultList.add(element);
        }

        // Add elements from array2, including overlapping elements
        for (String element : array2) {
            resultList.add(element);
        }

        // Convert the list back to an array
        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);

        return resultArray;
    }

    public static void main(String[] args) {
        // Example usage
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"c", "d", "e"};

        String[] result = concatenateStringArrays(array1, array2);

        for (String element : result) {
            System.out.print(element + " ");
        }
    }
}