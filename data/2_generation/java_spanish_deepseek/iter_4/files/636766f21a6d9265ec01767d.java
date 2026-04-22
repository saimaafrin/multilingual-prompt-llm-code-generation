public class ObjectToStringConverter {

    /**
     * Convierte un objeto a String; si el objeto es nulo, devuelve nulo, de lo contrario, devuelve toString();
     */
    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Object obj1 = null;
        Object obj2 = "Hola, mundo!";
        Object obj3 = 12345;

        System.out.println(toString(obj1)); // Debería imprimir "null"
        System.out.println(toString(obj2)); // Debería imprimir "Hola, mundo!"
        System.out.println(toString(obj3)); // Debería imprimir "12345"
    }
}