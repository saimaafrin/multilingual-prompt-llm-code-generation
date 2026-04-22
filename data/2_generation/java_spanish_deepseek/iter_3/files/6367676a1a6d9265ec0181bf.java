public class StringQuoter {

    public static Object quoteIfString(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return obj;
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(quoteIfString("miCadena")); // Salida: 'miCadena'
        System.out.println(quoteIfString(123));       // Salida: 123
        System.out.println(quoteIfString(true));      // Salida: true
    }
}