public class ObjectToStringConverter {

    /**
     * Conversione da 'Object' a stringa, se l'oggetto è nullo allora restituisce null, altrimenti restituisce toString();
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
        Object obj2 = 123;
        Object obj3 = "Hello, World!";

        System.out.println(toString(obj1)); // Output: null
        System.out.println(toString(obj2)); // Output: 123
        System.out.println(toString(obj3)); // Output: Hello, World!
    }
}