public class ObjectConverter {
    
    /** 
     * Convierte un objeto a String; si el objeto es nulo, devuelve nulo, de lo contrario, devuelve toString(); 
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = null;

        System.out.println(toString(obj1)); // Should print the object's string representation
        System.out.println(toString(obj2)); // Should print null
    }
}