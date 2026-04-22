import java.util.Arrays;

public class TrimArray {
    /** 
     * दिए गए String array के तत्वों को ट्रिम करें, प्रत्येक पर <code>String.trim()</code> कॉल करते हुए।
     * @param array मूल String array
     * @return परिणामस्वरूप array (उसी आकार का) जिसमें ट्रिम किए गए तत्व हैं
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        String[] trimmedArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            trimmedArray[i] = array[i] != null ? array[i].trim() : null;
        }
        return trimmedArray;
    }

    public static void main(String[] args) {
        String[] input = {"  Hello  ", "  World  ", null, "  Java  "};
        String[] output = trimArrayElements(input);
        System.out.println(Arrays.toString(output));
    }
}