public class ObjectUtils {

    /**
     * Restituisce il toString di un Object restituendo una stringa vuota ("") se l'input è null.
     * 
     * @param obj l'oggetto da toString, può essere null
     * @return il toString dell'oggetto passato, o una stringa vuota se l'input è null
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(ObjectUtils.toString(null));         // Output: ""
        System.out.println(ObjectUtils.toString(""));           // Output: ""
        System.out.println(ObjectUtils.toString("bat"));        // Output: "bat"
        System.out.println(ObjectUtils.toString(Boolean.TRUE)); // Output: "true"
    }
}