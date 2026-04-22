import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenator {

    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        List<String> resultList = new ArrayList<>();

        if (array1 != null) {
            for (String str : array1) {
                resultList.add(str);
            }
        }

        if (array2 != null) {
            for (String str : array2) {
                resultList.add(str);
            }
        }

        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c"};
        String[] array2 = {"d", "e", "f"};

        String[] result = concatenateStringArrays(array1, array2);
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}