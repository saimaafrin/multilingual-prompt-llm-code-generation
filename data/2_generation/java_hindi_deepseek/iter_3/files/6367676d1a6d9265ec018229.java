public class ArrayTrimmer {
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        String[] trimmedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                trimmedArray[i] = array[i].trim();
            } else {
                trimmedArray[i] = null;
            }
        }
        return trimmedArray;
    }
}