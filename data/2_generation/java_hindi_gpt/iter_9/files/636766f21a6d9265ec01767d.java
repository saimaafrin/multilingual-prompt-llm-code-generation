public class ObjectToStringConverter {

    /** 
     * ऑब्जेक्ट को स्ट्रिंग में बदलें, जब ऑब्जेक्ट null हो तो null लौटाएं, अन्यथा toString() लौटाएं; 
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = null;

        System.out.println(toString(obj1)); // Prints the string representation of obj1
        System.out.println(toString(obj2)); // Prints null
    }
}