import java.util.Arrays;

public class ArrayUtils {

    public static String[] addStringToArray(String[] array, String str) {
        // यदि इनपुट एरे null है, तो एक नया एरे बनाएं जिसमें केवल दिया गया स्ट्रिंग हो
        if (array == null) {
            return new String[]{str};
        }

        // नए एरे की लंबाई इनपुट एरे की लंबाई से 1 अधिक होगी
        String[] newArray = Arrays.copyOf(array, array.length + 1);

        // नए एरे के अंतिम स्थान पर दिया गया स्ट्रिंग जोड़ें
        newArray[newArray.length - 1] = str;

        // नया एरे लौटाएं
        return newArray;
    }

    public static void main(String[] args) {
        // टेस्ट केस
        String[] array = {"Hello", "World"};
        String str = "Java";
        String[] result = addStringToArray(array, str);
        System.out.println(Arrays.toString(result)); // [Hello, World, Java]

        // null एरे के साथ टेस्ट
        String[] nullArray = null;
        String[] result2 = addStringToArray(nullArray, str);
        System.out.println(Arrays.toString(result2)); // [Java]
    }
}