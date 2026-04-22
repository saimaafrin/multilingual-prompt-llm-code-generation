public class TypeManager {
    
    private List<Integer> initializedTypes;

    public TypeManager() {
        initializedTypes = new ArrayList<>();
    }

    /**
     * Aggiunge un tipo astratto alla lista dei tipi su cui viene invocato un costruttore nel blocco di base.
     * @param abstractType un tipo astratto su cui viene invocato un costruttore.
     */
    private void addInitializedType(final int abstractType) {
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }

    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }

    public static void main(String[] args) {
        TypeManager manager = new TypeManager();
        manager.addInitializedType(1);
        manager.addInitializedType(2);
        manager.addInitializedType(1); // Duplicate, should not be added

        System.out.println(manager.getInitializedTypes()); // Output: [1, 2]
    }
}