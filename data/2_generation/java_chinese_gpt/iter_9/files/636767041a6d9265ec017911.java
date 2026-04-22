public class ObjectRegistry {

    // A set to hold registered objects to avoid duplicates and infinite loops
    private static final Set<Object> registeredObjects = new HashSet<>();

    /** 
     * <p> 注册给定的对象。用于反射方法以避免无限循环。 </p>
     * @param value 要注册的对象。
     */
    static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot register a null object.");
        }
        if (!registeredObjects.add(value)) {
            System.out.println("Object is already registered: " + value);
        } else {
            System.out.println("Object registered successfully: " + value);
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        register(obj1); // Should register successfully
        register(obj2); // Should register successfully
        register(obj1); // Should indicate that obj1 is already registered
    }
}