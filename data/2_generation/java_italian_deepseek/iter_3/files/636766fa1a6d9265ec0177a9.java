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

    // Optional: Getter method to access the list of initialized types
    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }
}