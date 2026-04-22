import java.util.ArrayList;
import java.util.List;

public class TypeInitializer {
    private List<Integer> initializedTypes;

    public TypeInitializer() {
        this.initializedTypes = new ArrayList<>();
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
        TypeInitializer initializer = new TypeInitializer();
        initializer.addInitializedType(1);
        initializer.addInitializedType(2);
        initializer.addInitializedType(1); // Duplicate, should not be added

        System.out.println(initializer.getInitializedTypes()); // Output: [1, 2]
    }
}