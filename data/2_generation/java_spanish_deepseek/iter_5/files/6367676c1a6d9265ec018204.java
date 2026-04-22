import java.util.ArrayList;
import java.util.List;

public class StringArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        List<String> resultList = new ArrayList<>();

        if (array1 != null) {
            for (String element : array1) {
                resultList.add(element);
            }
        }

        if (array2 != null) {
            for (String element : array2) {
                resultList.add(element);
            }
        }

        // Convert the list to an array
        String[] resultArray = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

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