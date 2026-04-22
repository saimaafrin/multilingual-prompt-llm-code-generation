public class ObjectToStringConverter {

    /**
     * ऑब्जेक्ट को स्ट्रिंग में बदलें, जब ऑब्जेक्ट null हो तो null लौटाएं, अन्यथा toString() लौटाएं;
     */
    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static void main(String[] args) {
        // Test cases
        Object obj1 = null;
        Object obj2 = "Hello, World!";
        Object obj3 = 12345;

        System.out.println(toString(obj1)); // Should print "null"
        System.out.println(toString(obj2)); // Should print "Hello, World!"
        System.out.println(toString(obj3)); // Should print "12345"
    }
}