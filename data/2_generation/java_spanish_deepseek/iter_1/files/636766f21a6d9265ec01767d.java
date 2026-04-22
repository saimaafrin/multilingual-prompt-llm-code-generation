public class ObjectToStringConverter {

    /**
     * Convierte un objeto a String; si el objeto es nulo, devuelve nulo, de lo contrario, devuelve toString();
     * 
     * @param object El objeto a convertir a String.
     * @return El objeto convertido a String, o nulo si el objeto es nulo.
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
        Object obj2 = 12345;
        
        System.out.println(toString(obj1)); // Imprime: null
        System.out.println(toString(obj2)); // Imprime: 12345
    }
}