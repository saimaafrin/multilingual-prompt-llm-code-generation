import java.lang.reflect.Method;

public class ObjectRegistrar {

    /** 
     * <p> दिए गए ऑब्जेक्ट को रजिस्टर करता है। अनंत लूप से बचने के लिए रिफ्लेक्शन विधियों द्वारा उपयोग किया जाता है। </p>
     * @param value रजिस्टर करने के लिए ऑब्जेक्ट।
     */
    static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot register a null object.");
        }

        Class<?> clazz = value.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Registering object of class: " + clazz.getName());
        for (Method method : methods) {
            System.out.println("Found method: " + method.getName());
        }

        // Additional registration logic can be added here
    }

    public static void main(String[] args) {
        // Example usage
        Object myObject = new String("Hello, World!");
        register(myObject);
    }
}