public class TypeManager {
    
    // List to hold initialized types
    private List<Integer> initializedTypes;

    // Constructor
    public TypeManager() {
        initializedTypes = new ArrayList<>();
    }

    /** 
     * Agrega un tipo abstracto a la lista de tipos sobre los cuales se invoca un constructor en el bloque básico.
     * @param abstractType un tipo abstracto sobre el cual se invoca un constructor.
     */
    private void addInitializedType(final int abstractType) {
        initializedTypes.add(abstractType);
    }

    // Method to get the list of initialized types
    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }

    public static void main(String[] args) {
        TypeManager manager = new TypeManager();
        manager.addInitializedType(1);
        manager.addInitializedType(2);
        System.out.println(manager.getInitializedTypes());
    }
}