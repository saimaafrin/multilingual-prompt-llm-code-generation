public class StringUtils {

    /** 
     * Encuentra el primer índice dentro de una cadena, manejando <code>null</code>. Este método utiliza {@link String#indexOf(String)}. 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }
        return str.indexOf(searchStr);
    }

    public static void main(String[] args) {
        System.out.println(indexOf("Hello, world!", "world")); // Output: 7
        System.out.println(indexOf("Hello, world!", "Java"));  // Output: -1
        System.out.println(indexOf(null, "test"));              // Output: -1
        System.out.println(indexOf("test", null));              // Output: -1
    }
}