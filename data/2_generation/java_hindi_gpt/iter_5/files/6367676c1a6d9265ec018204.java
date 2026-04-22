import java.util.ArrayList;
import java.util.List;

public class ArrayConcatenation {

    /** 
     * दिए गए String arrays को एक में जोड़ें, जिसमें ओवरलैपिंग array तत्वों को दो बार शामिल किया गया है। <p> मूल arrays में तत्वों का क्रम संरक्षित रहता है।
     * @param array1 पहला array (यह <code>null</code> हो सकता है)
     * @param array2 दूसरा array (यह <code>null</code> हो सकता है)
     * @return नया array (<code>null</code> यदि दोनों दिए गए arrays <code>null</code> थे)
     */
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

        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] array1 = {"apple", "banana"};
        String[] array2 = {"banana", "cherry"};
        String[] result = concatenateStringArrays(array1, array2);
        
        for (String s : result) {
            System.out.println(s);
        }
    }
}