public class QuoteUtil {

    /** 
     * Turn the given Object into a String with single quotes if it is a String; keeping the Object as-is else.
     * @param obj the input Object (e.g. "myString")
     * @return the quoted String (e.g. "'myString'"), or the input object as-is if not a String
     */
    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(quoteIfString("myString")); // Output: 'myString'
        System.out.println(quoteIfString(123));        // Output: 123
        System.out.println(quoteIfString(null));        // Output: null
    }
}