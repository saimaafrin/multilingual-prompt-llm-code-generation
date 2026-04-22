public class TypeManager {
    
    // List to hold initialized types
    private List<Integer> initializedTypes;

    // Constructor to initialize the list
    public TypeManager() {
        initializedTypes = new ArrayList<>();
    }

    /**
     * Aggiunge un tipo astratto alla lista dei tipi su cui viene invocato un costruttore nel blocco di base.
     * @param abstractType un tipo astratto su cui viene invocato un costruttore.
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