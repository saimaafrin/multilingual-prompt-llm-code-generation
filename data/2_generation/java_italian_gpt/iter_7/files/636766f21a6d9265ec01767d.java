public class ObjectConverter {
    
    /** 
     * Conversione da 'Object' a stringa, se l'oggetto è nullo allora restituisce null, altrimenti restituisce toString(); 
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(toString(null)); // Output: null
        System.out.println(toString("Hello")); // Output: Hello
        System.out.println(toString(123)); // Output: 123
    }
}