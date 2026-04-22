public class StringQuoter {

    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(quoteIfString("myString")); // Output: 'myString'
        System.out.println(quoteIfString(123));        // Output: 123
        System.out.println(quoteIfString(true));       // Output: true
    }
}