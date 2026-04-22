public class ObjectConverter {
    
    /** 
     * Convierte un objeto a String; si el objeto es nulo, devuelve nulo, de lo contrario, devuelve toString(); 
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(toString(null)); // Debe imprimir: null
        System.out.println(toString("Hola")); // Debe imprimir: Hola
        System.out.println(toString(123)); // Debe imprimir: 123
    }
}