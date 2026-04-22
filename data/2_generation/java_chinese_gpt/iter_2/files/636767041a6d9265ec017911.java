public class ObjectRegistry {

    // A set to hold registered objects to avoid duplicates and infinite loops
    private static final Set<Object> registeredObjects = new HashSet<>();

    /** 
     * <p> 注册给定的对象。用于反射方法以避免无限循环。 </p>
     * @param value 要注册的对象。
     */
    static void register(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot register null object.");
        }
        if (!registeredObjects.contains(value)) {
            registeredObjects.add(value);
        }
    }

    public static void main(String[] args) {
        // Example usage
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        register(obj1);
        register(obj2);
        register(obj1); // This will not add obj1 again

        System.out.println("Registered objects: " + registeredObjects.size()); // Should print 2
    }
}