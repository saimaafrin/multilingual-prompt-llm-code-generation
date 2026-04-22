public class AbstractTypeManager {
    
    // List to hold initialized types
    private List<Integer> initializedTypes;

    // Constructor to initialize the list
    public AbstractTypeManager() {
        initializedTypes = new ArrayList<>();
    }

    /** 
     * एक अमूर्त प्रकार को उन प्रकारों की सूची में जोड़ता है जिन पर एक कंस्ट्रक्टर मूलभूत ब्लॉक में लागू होता है।
     * @param abstractType एक अमूर्त प्रकार जिस पर एक कंस्ट्रक्टर लागू होता है।
     */
    private void addInitializedType(final int abstractType) {
        // Add the abstract type to the list if it's not already present
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }

    // Method to get the list of initialized types
    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }

    public static void main(String[] args) {
        AbstractTypeManager manager = new AbstractTypeManager();
        manager.addInitializedType(1);
        manager.addInitializedType(2);
        manager.addInitializedType(1); // This will not add a duplicate

        System.out.println(manager.getInitializedTypes()); // Output: [1, 2]
    }
}